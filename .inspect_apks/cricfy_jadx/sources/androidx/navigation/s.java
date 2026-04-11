package androidx.navigation;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends y {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1396m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(int i, boolean z10) {
        super(z10);
        this.f1396m = i;
    }

    @Override // androidx.navigation.y
    public final Object a(String str, Bundle bundle) {
        switch (this.f1396m) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (String) bundle.get(str);
            case 1:
                return (String[]) bundle.get(str);
            case 2:
                return (Integer) bundle.get(str);
            case 3:
                return (Integer) bundle.get(str);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return (int[]) bundle.get(str);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return (Long) bundle.get(str);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return (long[]) bundle.get(str);
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return (Float) bundle.get(str);
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return (float[]) bundle.get(str);
            case 9:
                return (Boolean) bundle.get(str);
            default:
                return (boolean[]) bundle.get(str);
        }
    }

    @Override // androidx.navigation.y
    public final String b() {
        switch (this.f1396m) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "string";
            case 1:
                return "string[]";
            case 2:
                return "integer";
            case 3:
                return "reference";
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return "integer[]";
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return "long";
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return "long[]";
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return "float";
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return "float[]";
            case 9:
                return "boolean";
            default:
                return "boolean[]";
        }
    }

    @Override // androidx.navigation.y
    public final Object c(String str) {
        switch (this.f1396m) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return str;
            case 1:
                throw new UnsupportedOperationException("Arrays don't support default values.");
            case 2:
                return str.startsWith("0x") ? Integer.valueOf(Integer.parseInt(str.substring(2), 16)) : Integer.valueOf(Integer.parseInt(str));
            case 3:
                return str.startsWith("0x") ? Integer.valueOf(Integer.parseInt(str.substring(2), 16)) : Integer.valueOf(Integer.parseInt(str));
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                throw new UnsupportedOperationException("Arrays don't support default values.");
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                if (str.endsWith("L")) {
                    str = str.substring(0, str.length() - 1);
                }
                return str.startsWith("0x") ? Long.valueOf(Long.parseLong(str.substring(2), 16)) : Long.valueOf(Long.parseLong(str));
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                throw new UnsupportedOperationException("Arrays don't support default values.");
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return Float.valueOf(Float.parseFloat(str));
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                throw new UnsupportedOperationException("Arrays don't support default values.");
            case 9:
                if ("true".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(str)) {
                    return Boolean.FALSE;
                }
                throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
            default:
                throw new UnsupportedOperationException("Arrays don't support default values.");
        }
    }

    @Override // androidx.navigation.y
    public final void d(Bundle bundle, String str, Object obj) {
        switch (this.f1396m) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                bundle.putString(str, (String) obj);
                break;
            case 1:
                bundle.putStringArray(str, (String[]) obj);
                break;
            case 2:
                bundle.putInt(str, ((Integer) obj).intValue());
                break;
            case 3:
                bundle.putInt(str, ((Integer) obj).intValue());
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                bundle.putIntArray(str, (int[]) obj);
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                bundle.putLong(str, ((Long) obj).longValue());
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                bundle.putLongArray(str, (long[]) obj);
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                bundle.putFloat(str, ((Float) obj).floatValue());
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                bundle.putFloatArray(str, (float[]) obj);
                break;
            case 9:
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                break;
            default:
                bundle.putBooleanArray(str, (boolean[]) obj);
                break;
        }
    }
}
