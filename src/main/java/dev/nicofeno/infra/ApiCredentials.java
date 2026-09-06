package dev.nicofeno.infra;

public record ApiCredentials(String apiKey) {
    public ApiCredentials {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("La API key es obligatoria");
        }
    }
}
