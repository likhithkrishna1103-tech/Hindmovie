package androidx.media;

import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1527a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1528b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1529c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1530d = -1;

    public final boolean equals(Object obj) {
        int i;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f1528b == audioAttributesImplBase.f1528b) {
            int i10 = this.f1529c;
            int i11 = audioAttributesImplBase.f1529c;
            int i12 = audioAttributesImplBase.f1530d;
            if (i12 == -1) {
                int i13 = audioAttributesImplBase.f1527a;
                int i14 = AudioAttributesCompat.f1523b;
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
                            case j.LONG_FIELD_NUMBER /* 4 */:
                                break;
                            case j.STRING_FIELD_NUMBER /* 5 */:
                            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                            case 8:
                            case 9:
                            case 10:
                                i = 5;
                                break;
                            case j.STRING_SET_FIELD_NUMBER /* 6 */:
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
            if (i10 == (i11 & 273) && this.f1527a == audioAttributesImplBase.f1527a && this.f1530d == i12) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1528b), Integer.valueOf(this.f1529c), Integer.valueOf(this.f1527a), Integer.valueOf(this.f1530d)});
    }

    public final String toString() {
        String strL;
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f1530d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f1530d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        int i = this.f1527a;
        int i10 = AudioAttributesCompat.f1523b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                strL = "USAGE_UNKNOWN";
                break;
            case 1:
                strL = "USAGE_MEDIA";
                break;
            case 2:
                strL = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strL = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
                strL = "USAGE_ALARM";
                break;
            case j.STRING_FIELD_NUMBER /* 5 */:
                strL = "USAGE_NOTIFICATION";
                break;
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                strL = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                strL = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strL = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strL = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strL = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strL = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strL = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strL = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strL = "USAGE_GAME";
                break;
            case 15:
            default:
                strL = e6.j.l("unknown usage ", i);
                break;
            case 16:
                strL = "USAGE_ASSISTANT";
                break;
        }
        sb2.append(strL);
        sb2.append(" content=");
        sb2.append(this.f1528b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f1529c).toUpperCase());
        return sb2.toString();
    }
}
