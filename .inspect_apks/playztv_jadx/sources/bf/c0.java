package bf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends IOException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2063u;

    /* JADX WARN: Illegal instructions before constructor call */
    public c0(int i) {
        String str;
        l4.a.u("errorCode", i);
        switch (i) {
            case 1:
                str = "NO_ERROR";
                break;
            case 2:
                str = "PROTOCOL_ERROR";
                break;
            case 3:
                str = "INTERNAL_ERROR";
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                str = "FLOW_CONTROL_ERROR";
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                str = "SETTINGS_TIMEOUT";
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "STREAM_CLOSED";
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "FRAME_SIZE_ERROR";
                break;
            case 8:
                str = "REFUSED_STREAM";
                break;
            case 9:
                str = "CANCEL";
                break;
            case 10:
                str = "COMPRESSION_ERROR";
                break;
            case 11:
                str = "CONNECT_ERROR";
                break;
            case 12:
                str = "ENHANCE_YOUR_CALM";
                break;
            case 13:
                str = "INADEQUATE_SECURITY";
                break;
            case 14:
                str = "HTTP_1_1_REQUIRED";
                break;
            default:
                str = "null";
                break;
        }
        super("stream was reset: ".concat(str));
        this.f2063u = i;
    }
}
