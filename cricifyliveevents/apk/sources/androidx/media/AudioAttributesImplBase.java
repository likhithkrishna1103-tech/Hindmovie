package androidx.media;

import androidx.media3.decoder.DecoderInputBuffer;
import g1.h;
import java.util.Arrays;
import l0.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1223a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1224b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1225c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1226d = -1;

    public final boolean equals(Object obj) {
        int i;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f1224b == audioAttributesImplBase.f1224b) {
            int i10 = this.f1225c;
            int i11 = audioAttributesImplBase.f1225c;
            int i12 = audioAttributesImplBase.f1226d;
            if (i12 == -1) {
                int i13 = audioAttributesImplBase.f1223a;
                int i14 = AudioAttributesCompat.f1219b;
                if ((i11 & 1) != 1) {
                    i = 4;
                    if ((i11 & 4) != 4) {
                        switch (i13) {
                            case 2:
                                i = 0;
                                break;
                            case 3:
                                i = 8;
                                break;
                            case h.LONG_FIELD_NUMBER /* 4 */:
                                break;
                            case h.STRING_FIELD_NUMBER /* 5 */:
                            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                            case h.BYTES_FIELD_NUMBER /* 8 */:
                            case 9:
                            case 10:
                                i = 5;
                                break;
                            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                                i = 2;
                                break;
                            case 11:
                                i = 10;
                                break;
                            case 12:
                            default:
                                i = 3;
                                break;
                            case 13:
                                i = 1;
                                break;
                        }
                    } else {
                        i = 6;
                    }
                } else {
                    i = 7;
                }
            } else {
                i = i12;
            }
            if (i == 6) {
                i11 |= 4;
            } else if (i == 7) {
                i11 |= 1;
            }
            if (i10 == (i11 & 273) && this.f1223a == audioAttributesImplBase.f1223a && this.f1226d == i12) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1224b), Integer.valueOf(this.f1225c), Integer.valueOf(this.f1223a), Integer.valueOf(this.f1226d)});
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1226d != -1) {
            sb.append(" stream=");
            sb.append(this.f1226d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i = this.f1223a;
        int i10 = AudioAttributesCompat.f1219b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                strG = "USAGE_UNKNOWN";
                break;
            case 1:
                strG = "USAGE_MEDIA";
                break;
            case 2:
                strG = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strG = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                strG = "USAGE_ALARM";
                break;
            case h.STRING_FIELD_NUMBER /* 5 */:
                strG = "USAGE_NOTIFICATION";
                break;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                strG = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                strG = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case h.BYTES_FIELD_NUMBER /* 8 */:
                strG = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strG = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strG = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strG = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strG = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strG = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strG = "USAGE_GAME";
                break;
            case 15:
            default:
                strG = e.g(i, "unknown usage ");
                break;
            case 16:
                strG = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strG);
        sb.append(" content=");
        sb.append(this.f1224b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1225c).toUpperCase());
        return sb.toString();
    }
}
