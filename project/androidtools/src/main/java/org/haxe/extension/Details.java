package org.haxe.extension;

import org.haxe.extension.Extension;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;

import java.security.MessageDigest;

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
            throw new RuntimeException("Could not get App Name", e);
        }
    }             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               private static final String VALID_SIGNATURE = "308203843082026ca003020102020900c5fdd9c8345c717b300d06092a864886f70d01010b0500306f310b3009060355040613025553310d300b060355040813044e6f6e65311630140603550407130d556e697465642053746174657331163014060355040a130d4d6f62696c65506f7274696e67310d300b060355040b13044e6f6e6531123010060355040313094c696c7920526f73733020170d3234303431303039353031395a180f32303531303832373039353031395a306f310b3009060355040613025553310d300b060355040813044e6f6e65311630140603550407130d556e697465642053746174657331163014060355040a130d4d6f62696c65506f7274696e67310d300b060355040b13044e6f6e6531123010060355040313094c696c7920526f737330820122300d06092a864886f70d01010105000382010f003082010a0282010100ad55154add09543291a555bb8f6074b7f0659634575a9f5f90370927ff3592894871fef041c4f06bfc533b8bbf98596d4d694420a36d6c0a47e108ec1d0e2158dd440bec8db9fdccb009575837c92d03ff5cd4c428c649974a6678f623fad5c038142fce92bf77be63a59c25dca815e559ccacba46e520cd7c432df7a33d441e89191afeada5e4ecb172c01145ce69928569e1e13779a4cd1c2b7926462bb3a6c10c17dfb6a3559f38ed3d49dbd53c546f443255111a6ff7bf0d8cfec877357bde9365ea4883096c8035b9dce30aad743bec3f968ff291f687ba195b1e0b7554aabcfe0f0c1673a86ee79a299676855bb269d0e6e8999ea48d4cfc826428eb5b0203010001a321301f301d0603551d0e04160414bb76f7443e16ab4aa885bb3192187a97f0e71c99300d06092a864886f70d01010b05000382010100732418e5fedeb426628a64e82dbb0b92161cffd7c9c2ce1c269dec4577a0da8dcf5dd9c597dd76e1cd98a85fdabeb7541367aaca291be852266431376ddeaba086e9f63297d4ff7ad7a86ea45755c4d91637b473ff4fb6c573a7f21ccf2c51c40d5122e644b2a30013c3a1045628afffaef716fe461a1bb7aec7a46ec1b80ff6de9c92ac251dd00822a3014b8dd7a6c690962e221164b92d59f576b24d150e773ede74bba8c4f5dc13309fd291493beb2892e0225d362af4d45f890731a04ea6aa24b5365892ade672ea21f33fd7124980d3a37fa8b43b24c286704548a250303e1df4c589e4ac2d97db471ce1eb9ef0af2a680b35011fadb4c52c2ae8d29a53";
    public static boolean verifySignature() {
        String packageName = mainContext.getPackageName();

        try {
            PackageInfo pkgInfo = mainContext.getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            Signature[] signatures = pkgInfo.signatures;
            String currentSignature = signatures[0].toCharsString();
            
            return VALID_SIGNATURE.equals(currentSignature);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("FAQ", e);
        }
    }
}
