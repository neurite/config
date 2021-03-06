package org.computelab.config;

/**
 * A configuration entry is a typed key-value pair.
 *
 * @param <K> the type of the config entry's key
 * @param <V> the type of the config entry's value
 */
public interface ConfigEntry<K, V> {

    /**
     * @return the key of the config entry
     */
    K key();

    /**
     * @return the value of the config entry.
     */
    V value();
}
