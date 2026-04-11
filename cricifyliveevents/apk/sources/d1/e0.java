package d1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends ge.j implements fe.l {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3222w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3223x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(int i, Object obj) {
        super(1);
        this.f3222w = i;
        this.f3223x = obj;
    }

    @Override // fe.l
    public final Object a(Object obj) {
        switch (this.f3222w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Throwable th = (Throwable) obj;
                h0 h0Var = (h0) this.f3223x;
                rd.j jVar = h0Var.f3242j;
                if (th != null) {
                    h0Var.f3241h.v(new r0(th));
                }
                if (jVar.a()) {
                    ((o0) jVar.getValue()).close();
                }
                return rd.l.f11003a;
            default:
                File file = (File) obj;
                ge.i.e(file, "it");
                return new z0(((ue.c) this.f3223x).f12461v, file);
        }
    }
}
