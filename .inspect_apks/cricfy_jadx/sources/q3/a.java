package q3;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.List;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10359c;

    public a(int i, long j4, long j7) {
        this.f10357a = i;
        switch (i) {
            case 2:
                this.f10358b = j4;
                this.f10359c = j7;
                break;
            default:
                this.f10358b = j7;
                this.f10359c = j4;
                break;
        }
    }

    public static long d(long j4, t tVar) {
        long jX = tVar.x();
        if ((128 & jX) != 0) {
            return 8589934591L & ((((jX & 1) << 32) | tVar.z()) + j4);
        }
        return -9223372036854775807L;
    }

    @Override // q3.b
    public final String toString() {
        switch (this.f10357a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                StringBuilder sb = new StringBuilder("SCTE-35 PrivateCommand { ptsAdjustment=");
                sb.append(this.f10358b);
                sb.append(", identifier= ");
                return q4.a.p(sb, this.f10359c, " }");
            case 1:
                StringBuilder sb2 = new StringBuilder("SCTE-35 SpliceInsertCommand { programSplicePts=");
                sb2.append(this.f10358b);
                sb2.append(", programSplicePlaybackPositionUs= ");
                return q4.a.p(sb2, this.f10359c, " }");
            default:
                StringBuilder sb3 = new StringBuilder("SCTE-35 TimeSignalCommand { ptsTime=");
                sb3.append(this.f10358b);
                sb3.append(", playbackPositionUs= ");
                return q4.a.p(sb3, this.f10359c, " }");
        }
    }

    public a(long j4, long j7, List list) {
        this.f10357a = 1;
        this.f10358b = j4;
        this.f10359c = j7;
        Collections.unmodifiableList(list);
    }
}
