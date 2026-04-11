package com.cncverse;

import com.lagradost.cloudstream3.MainAPIKt;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CryptoUtils.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u000fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/cncverse/CryptoUtils;", "", "<init>", "()V", "CRICIFY_PROVIDER_SECRET1", "", "getCRICIFY_PROVIDER_SECRET1", "()Ljava/lang/String;", "CRICIFY_PROVIDER_SECRET1$delegate", "Lkotlin/Lazy;", "CRICIFY_PROVIDER_SECRET2", "getCRICIFY_PROVIDER_SECRET2", "CRICIFY_PROVIDER_SECRET2$delegate", "KEYS", "", "Lcom/cncverse/CryptoUtils$KeyInfo;", "getKEYS", "()Ljava/util/Map;", "KEYS$delegate", "parseKeyInfo", "secret", "hexStringToByteArray", "", "hex", "decryptData", "encryptedBase64", "tryDecrypt", "ciphertext", "keyInfo", "KeyInfo", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CryptoUtils {

    @NotNull
    public static final CryptoUtils INSTANCE = new CryptoUtils();

    /* JADX INFO: renamed from: CRICIFY_PROVIDER_SECRET1$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy CRICIFY_PROVIDER_SECRET1 = LazyKt.lazy(new Function0() { // from class: com.cncverse.CryptoUtils$$ExternalSyntheticLambda0
        public final Object invoke() {
            return CryptoUtils.CRICIFY_PROVIDER_SECRET1_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: CRICIFY_PROVIDER_SECRET2$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy CRICIFY_PROVIDER_SECRET2 = LazyKt.lazy(new Function0() { // from class: com.cncverse.CryptoUtils$$ExternalSyntheticLambda1
        public final Object invoke() {
            return CryptoUtils.CRICIFY_PROVIDER_SECRET2_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: KEYS$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy KEYS = LazyKt.lazy(new Function0() { // from class: com.cncverse.CryptoUtils$$ExternalSyntheticLambda2
        public final Object invoke() {
            return CryptoUtils.KEYS_delegate$lambda$0();
        }
    });

    private CryptoUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CRICIFY_PROVIDER_SECRET1_delegate$lambda$0() {
        return "3368487a78594167534749382f68616d:557143766b766a656345497a38343256";
    }

    private final String getCRICIFY_PROVIDER_SECRET1() {
        return (String) CRICIFY_PROVIDER_SECRET1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CRICIFY_PROVIDER_SECRET2_delegate$lambda$0() {
        return "4d7165594743543441594b6f484b7254:6f484b725451755078387a6c386f4a2b";
    }

    private final String getCRICIFY_PROVIDER_SECRET2() {
        return (String) CRICIFY_PROVIDER_SECRET2.getValue();
    }

    private final Map<String, KeyInfo> getKEYS() {
        return (Map) KEYS.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map KEYS_delegate$lambda$0() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("key1", INSTANCE.parseKeyInfo(INSTANCE.getCRICIFY_PROVIDER_SECRET1())), TuplesKt.to("key2", INSTANCE.parseKeyInfo(INSTANCE.getCRICIFY_PROVIDER_SECRET2()))});
    }

    private final KeyInfo parseKeyInfo(String secret) {
        List parts = StringsKt.split$default(secret, new String[]{":"}, false, 0, 6, (Object) null);
        return new KeyInfo(hexStringToByteArray((String) parts.get(0)), hexStringToByteArray((String) parts.get(1)));
    }

    /* JADX INFO: compiled from: CryptoUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/cncverse/CryptoUtils$KeyInfo;", "", "key", "", "iv", "<init>", "([B[B)V", "getKey", "()[B", "getIv", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class KeyInfo {

        @NotNull
        private final byte[] iv;

        @NotNull
        private final byte[] key;

        public static /* synthetic */ KeyInfo copy$default(KeyInfo keyInfo, byte[] bArr, byte[] bArr2, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = keyInfo.key;
            }
            if ((i & 2) != 0) {
                bArr2 = keyInfo.iv;
            }
            return keyInfo.copy(bArr, bArr2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getKey() {
            return this.key;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getIv() {
            return this.iv;
        }

        @NotNull
        public final KeyInfo copy(@NotNull byte[] key, @NotNull byte[] iv) {
            return new KeyInfo(key, iv);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KeyInfo)) {
                return false;
            }
            KeyInfo keyInfo = (KeyInfo) other;
            return Intrinsics.areEqual(this.key, keyInfo.key) && Intrinsics.areEqual(this.iv, keyInfo.iv);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.key) * 31) + Arrays.hashCode(this.iv);
        }

        @NotNull
        public String toString() {
            return "KeyInfo(key=" + Arrays.toString(this.key) + ", iv=" + Arrays.toString(this.iv) + ')';
        }

        public KeyInfo(@NotNull byte[] key, @NotNull byte[] iv) {
            this.key = key;
            this.iv = iv;
        }

        @NotNull
        public final byte[] getIv() {
            return this.iv;
        }

        @NotNull
        public final byte[] getKey() {
            return this.key;
        }
    }

    private final byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, len), 2);
        int i = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
            while (true) {
                data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
                if (i == last) {
                    break;
                }
                i += step;
            }
        }
        return data;
    }

    @Nullable
    public final String decryptData(@NotNull String encryptedBase64) {
        try {
            String cleanBase64 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim(encryptedBase64).toString(), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null), " ", "", false, 4, (Object) null), "\t", "", false, 4, (Object) null);
            byte[] ciphertext = MainAPIKt.base64DecodeArray(cleanBase64);
            for (Map.Entry<String, KeyInfo> entry : getKEYS().entrySet()) {
                entry.getKey();
                KeyInfo keyInfo = entry.getValue();
                String result = tryDecrypt(ciphertext, keyInfo);
                if (result != null) {
                    return result;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final String tryDecrypt(byte[] ciphertext, KeyInfo keyInfo) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyInfo.getKey(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(keyInfo.getIv());
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(ciphertext);
            String text = new String(decrypted, Charsets.UTF_8);
            if (!StringsKt.startsWith$default(text, "{", false, 2, (Object) null) && !StringsKt.startsWith$default(text, "[", false, 2, (Object) null)) {
                if (!StringsKt.contains(text, "http", true)) {
                    return null;
                }
            }
            return text;
        } catch (Exception e) {
            return null;
        }
    }
}
