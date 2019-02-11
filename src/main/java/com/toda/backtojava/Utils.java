package com.toda.backtojava;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Utils {

    static String format(String text) {
        return text.isEmpty() ? null : text;
    }

    @Nullable
    static String formatSafe(@NotNull String text) {
        return text.isEmpty() ? null : text;
    }
}
