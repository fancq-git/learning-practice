package com.tydic.lambda;

public interface Converter<F, T> {
    T convert(F from);
}
