package m3;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.List;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8304c;

    public a(int i, long j5, long j8) {
        this.f8302a = i;
        switch (i) {
            case 2:
                this.f8303b = j5;
                this.f8304c = j8;
                break;
            default:
                this.f8303b = j8;
                this.f8304c = j5;
                break;
        }
    }

    public static long d(long j5, u uVar) {
        long jX = uVar.x();
        if ((128 & jX) != 0) {
            return 8589934591L & ((((jX & 1) << 32) | uVar.z()) + j5);
        }
        return -9223372036854775807L;
    }

    @Override // m3.b
    public final String toString() {
        switch (this.f8302a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                StringBuilder sb2 = new StringBuilder("SCTE-35 PrivateCommand { ptsAdjustment=");
                sb2.append(this.f8303b);
                sb2.append(", identifier= ");
                return l4.a.n(sb2, this.f8304c, " }");
            case 1:
                StringBuilder sb3 = new StringBuilder("SCTE-35 SpliceInsertCommand { programSplicePts=");
                sb3.append(this.f8303b);
                sb3.append(", programSplicePlaybackPositionUs= ");
                return l4.a.n(sb3, this.f8304c, " }");
            default:
                StringBuilder sb4 = new StringBuilder("SCTE-35 TimeSignalCommand { ptsTime=");
                sb4.append(this.f8303b);
                sb4.append(", playbackPositionUs= ");
                return l4.a.n(sb4, this.f8304c, " }");
        }
    }

    public a(long j5, long j8, List list) {
        this.f8302a = 1;
        this.f8303b = j5;
        this.f8304c = j8;
        Collections.unmodifiableList(list);
    }
}
