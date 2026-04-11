package j2;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class o extends y1.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f6709u;

    public o(IllegalStateException illegalStateException, p pVar) {
        StringBuilder sb2 = new StringBuilder("Decoder failed: ");
        sb2.append(pVar == null ? null : pVar.f6710a);
        super(sb2.toString(), illegalStateException);
        boolean z2 = illegalStateException instanceof MediaCodec.CodecException;
        if (z2) {
            ((MediaCodec.CodecException) illegalStateException).getDiagnosticInfo();
        }
        this.f6709u = z2 ? ((MediaCodec.CodecException) illegalStateException).getErrorCode() : 0;
    }
}
