package org.computelab.config;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

abstract class AbstractConfigReader<T> implements ConfigReader<String, T>  {

    @Override
    public ConfigEntry<String, T> get(final String key) {
        validateKey(key);
        final T val = getVal(key);
        if (val == null) {
            throw new ConfigEntryMissingException(key);
        }
        return new ConfigEntry<String, T>() {
            @Override
            public String key() {
                return key;
            }
            @Override
            public T value() {
                return val;
            }
        };
    }

    @Override
    public boolean has(final String key) {
        validateKey(key);
        return getVal(key) != null;
    }

    /**
     * The value for the specified key; or null if not exist
     */
    abstract T getVal(String key);

    private void validateKey(final String key) {
        checkNotNull(key, "Key for the config entry must not be null.");
        checkArgument(!key.isEmpty(), "Key for the config entry must not be empty.");
    }
}
