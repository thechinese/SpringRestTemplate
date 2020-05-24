package de.cheng.templateservice.util;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Utility class to wrap the static function of the unfold operation.
 */
public final class Utilities {

  /**
   * This functions inputs a {@link Collection} of {@link Optional} elements in a generic manner
   * with only the invariant, that the base type has to implement / extend the {@link Comparable}
   * class implementation.
   * <p>
   * If so, the elements, wich are {@link Optional#empty()} representing {@link
   * NullPointerException} wrappers, will be outfiltered, all other elements will be unwrapped and
   * sorted. Finally, a {@link List} of the base elements will be returned.
   *
   * @param optionals The {@link Collection} of {@link Optional}s to be unfolded.
   * @param <E> The generic type parameter supporting any kind of {@link Comparable}s.
   * @return A ascending sorted, {@link List} of unique, non empty elements.
   */
  public static <E extends Comparable<? super E>> List<E> unfold(
    final Collection<Optional<E>> optionals) {
    return optionals
      // Use parallel streaming, since the order of unwrapping
      // is irrelevant for thread-safety in this step.
      .parallelStream()
      // Outfilter all NullPointers
      .filter(Optional::isPresent)
      // Map to a linear and now thread-safe stream.
      .map(Optional::get)
      // First remove duplicates to sort less elements.
      .distinct()
      // Sort the resulting collection.
      .sorted()
      // Finally wrap to a proper List.
      .collect(Collectors.toList());
  }
}
