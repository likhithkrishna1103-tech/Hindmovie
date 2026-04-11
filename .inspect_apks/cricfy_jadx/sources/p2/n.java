package p2;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class n extends e2.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9924v;

    public n(IllegalStateException illegalStateException, o oVar) {
        StringBuilder sb = new StringBuilder("Decoder failed: ");
        sb.append(oVar == null ? null : oVar.f9925a);
        super(sb.toString(), illegalStateException);
        boolean z10 = illegalStateException instanceof MediaCodec.CodecException;
        if (z10) {
            ((MediaCodec.CodecException) illegalStateException).getDiagnosticInfo();
        }
        this.f9924v = z10 ? ((MediaCodec.CodecException) illegalStateException).getErrorCode() : 0;
    }
}
