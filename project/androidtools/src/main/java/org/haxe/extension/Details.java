package org.haxe.extension;

import org.haxe.extension.Extension;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import android.util.Base64;

public class Details extends Extension {

    public static String getVersionName() {
        try {
            return mainContext.getPackageManager().getPackageInfo(mainContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get version name", e);
        }
    }

    public static int getVersionCode() {
        try {
            return mainContext.getPackageManager().getPackageInfo(mainContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get version code", e);
        }
    }

    public static String getPackageName() {
        return mainContext.getPackageName();
    }

    public static String getAppName() {
        try {
            PackageInfo packageInfo = mainContext.getPackageManager()
                    .getPackageInfo(mainContext.getPackageName(), 0);
            return packageInfo.applicationInfo.loadLabel(mainContext.getPackageManager()).toString();
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get app name", e);
        }
    }             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    private static final String VALID_SIGNATURE = "MIIKygIBAzCCCnQGCSqGSIb3DQEHAaCCCmUEggphMIIKXTCCBbQGCSqGSIb3DQEHAaCCBaUEggWhMIIFnTCCBZkGCyqGSIb3DQEMCgECoIIFQDCCBTwwZgYJKoZIhvcNAQUNMFkwOAYJKoZIhvcNAQUMMCsEFOuc+rhovKnwuYymiEi8PdwXJEyWAgInEAIBIDAMBggqhkiG9w0CCQUAMB0GCWCGSAFlAwQBKgQQJxRkNaXAthZAgZzlQGm8MASCBNDBMbsrXye3/FB9bvprw2B3qZ2ACArPZhTbLkeQB49FK4zG06UtAeFomb7BcIVnRuZm6RZfDZ96kEr6loCMMa2iUIs22ZCQty5QIuQpYTULcAhHxkPXDUWdC7GVObpYJ9HmEcZlBO7mfNQb4Ms3tY2shxTrcmz82RAC/hyiOnURo5CZg1LKp2W8CZmzZpm/s4egYy1aGZrv4c87aSXCyM/1h80TGX2vq4LmqE/GWG0qgT1XHejp8oxAKHA5VkoJXfqxiKsijb13ubxhPvuBstVclglzTlxHYgZIZ7WW4PUkl5ILQ7OtHr7PpOEFhXQf9ZUrSiWEdrqmLlzx70M1N69+aHjcKk3qKgS2Y/4Xf9//+6MRp1gkIUhK3TLXUEir6QRhbkxSfp1f7UNBgBON8muZ7FaGjaX1d2fC4MqY/kiHRjq1l9nd/cbzmx8KXZGpCyg4opSh3KhH5fhZpAJmlMt9NvBuVfFZY82Lw6i7KsS5zCsCjEeSjuewH0IXGsPrVfjnbuFJ6GqE/0TGze1ZlNkKTQS+76d1PdUz8ofoPiNRwuy89R1O3/6+kjABDRGQCA6OcDsKf7PhngofUW7idyrUSPDwrg+pGdeXVn3EJ5IgCcsgXMew7WtNdokeEN24B1Am3zU4kPRnuY3OfBHuwh1R01S7HRcfgopknFwwnASeJoUhIqVmR8QkMFxWiK442Fr+GFdtPRHTNxPH0cfspDtMl4meMfL0z2s6JARVyGSv9OUfktHj6yFdbiR6zsaduVaHShkoqSkAt6UA/wnpyMoihq36x+CzFCcK3VwFYy36dD8tXk1j5NXZVZ4BCTQwaM12MoFbN0aXIHeHLiP+jX6d1KOskmJY2l+kJaGA1imwSfQUTL23RFtEyoLuPkrR45lF7TE9LqYXfry/+C2jgIA+oHteqkuD69SNAcFAu+2wazJLiwBHLNDybk1KtcPtg0ib7MMKmlXf8ZOwd3cztD7wWicMUeg9WnyIpRddu18K6IppQiq1VgZ77tQP6412keRbdMvgaEIQJQ2rtk7G1ddyJ4DdjwFxgJ4FaHhcpyRX1imt4QzVpuOMjzCVAAUGPx04qhWDYjjw4h2LGkIZSdinabGNu6y9EwhuTlOR4viZglVL8RoaeVW1dT/gyUZZken7wiKlYM12fm0ThNoBwu6pPvFfsv3dYo8UzQ5rlXnnFi2vQ9LGqpQbEQRjeL2xEXL0HQMqIkt/TbCz4H0JSH2O36qQ38yQ8xVIcsTvUUtshbRlnFvKMlJlCc/THTBLxbQrk4hvjSNi8kSZFHMrHZ1NsUjkktvwQeO3mPcBQ2OnBvbp6n+vBeuF/WrnJvxld4Dyd4UC7wCAcI4Lc+0HVbgeJYeorhk8kWzlR0DZQZ+DckK8hYNdszcX2DQ979CWQf4ya6HKKXzXjcbBBZ+DsoCsSU/3BDgHPHxVhSdCd/IRAMlarBdLBREgrWU8AHFvLB/nZSNuOtaE/Two0UN62OE8dPVSdGzXavT0Rth7uDSkNEtEzdlBXM6xYcDdRYEtBD8RZYAAUOi1ms2k97X+TtnOYBV561kl/I+W7falco0fCot2LS9ipz34jT83OSjOLSqg2gta2RUAdRhBrZyI67FeHHRmKmZ5BI9b/9vrrPX7zzFGMCEGCSqGSIb3DQEJFDEUHhIAcABzAHkAYwBoAHAAbwByAHQwIQYJKoZIhvcNAQkVMRQEElRpbWUgMTcxMjc0MjYxOTAyOTCCBKEGCSqGSIb3DQEHBqCCBJIwggSOAgEAMIIEhwYJKoZIhvcNAQcBMGYGCSqGSIb3DQEFDTBZMDgGCSqGSIb3DQEFDDArBBROEANe0hSgKQgH2E7ou8uc+AfRLgICJxACASAwDAYIKoZIhvcNAgkFADAdBglghkgBZQMEASoEECeVC0e/TqSNYOXGof07SFOAggQQfuSMiACasQSVnPg+PsSxaiJGX8G7iXPZRBgGzE/1NSh9WIxK276GlLC0lYe0VyTJOii3yFsRl1E6TEqYIaS4jp0KElhBAnRHOECgNevXxS0oaIJPEMp/l8DXp7fwhWAWJDD2a2j8hSWIOOB+VItfQ6/1BPAt5igzpGbkidCq6ZbejwohuodWD494fsVAuw/KK3bDV3lz08ZEmIG2f9+aX0GYnMAOEckETBr92h5EXyRf9XGJeZ0rVRTdifuv0M1x+QvtFcFxat3AVuYto6muvIvrtwWy3VQsHJV7CptqYLf0v9KCxWTsxRxtUTATMNrSWRrXyqAOI2sUK7BmBNVLPmJzINh0pOGWGSX8NGos63DYO4h1DaJBZdGtZVGtOQXYmoyvRY7qIOtfJq4r/2h4c2Zx6K7PA48s4gRT3CyA4A2c0CULwJ5hBTiyl2Cl4Zdyw+OBadJUY7SRpU8gt9UcIXfIfpaPlc5BSJT6YXFEW9O3fOaIcpcBCRrkWwIHgMb1BHkCWMyuLYJmpsn6J5kdz2hdrppvqzSGgJn00NAKbii5ps3GeJTwriS1AuUktdkT8CQbE0rUEniZnzQxkXPDQtxQU7/aSf/XpAviv+bXneZfh+kGwT2jMj5X1FMwWGK1d77BwFLyEEHoKd4QvFW+AeYVE79VM4DaKpiDiEOQqEgK13kLYC9/x+JIM7GHOVxECmhX89jkcC7hv4MOhvvuJK8bkY8GcomRUS3ACFvmIpIIFKRAv7FFJ7FRTyPGHdIsw825gAX2l/FuqKbpOD3hnXapI3NukmNyKsZCfTbHzgAgVnJqoEjUCBmjgd/T0fl8oNNGlK5ZEkI0tPVBRvPbux3YeoTViJ0x+IFEjhX7rxStUCV9j1KUFnbXupgQWavwtfXU3mg8F4waxN5ELEYYQJkEeqdvAwF+K7uH9KB9R1CPzfikM/VeKDP0z4Lw4eX0rjQdJz3t4I0TXEpaFD9aRMesBNzPkH8/ixeUhSPzwpRoy6EAe8vlwaw3NlrHtpdryJtZusmR3JtTOB/8Uno2FgVKRPHIEHkyp02oO0vincr8xnUQBk7K+3vn5L88VnAUJkSA6uBero3qRycqmGD4H34vgSmsFOXTVvJ04DKUEqffnI8m9ddKoUbmDLnRq+NCcHn3b6FqpZ4i6KjHxHfwtwqSrjxn+6H0q1ne/v9vwFixWQ4KTWntGBPTCWMMar3NsXqzELMY4kyar5VSSMqwqfXEXFuHP+QoNVwhf/fIcTLd7LH5PTSkulBjM2h/t831XTa/aRbMCjMoNYFwed9BIh+ckmNfVJTBmqgItz1RCuLoiCmr8xYeQqaQ17pQbTcJsieIQIUNm2ym4rJLySErqnQpx6G1Q82IEv4QlnGxTiEwTTAxMA0GCWCGSAFlAwQCAQUABCAw7VoAtZjQgYPL0I93uC3NCbxSRost98BJG8xO7qwHSQQUNGbtafQEH5YKm1qvEhYjGGXEBnECAicQ";
    public static boolean verifySignature() {
        try {
            PackageInfo packageInfo = mainContext.getPackageManager().getPackageInfo(
                    mainContext.getPackageName(),
                    PackageManager.GET_SIGNATURES
            );
            for (android.content.pm.Signature signature : packageInfo.signatures) {
                String base64Signature = Base64.encodeToString(signature.toByteArray(), Base64.NO_WRAP);
                if (base64Signature.equals(VALID_SIGNATURE)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("error", e);
        }
        throw new RuntimeException("cant find");
    }
}
