package rf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11094v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ q f11095w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f11096x;

    public /* synthetic */ l(q qVar, int i, Object obj, int i10) {
        this.f11094v = i10;
        this.f11095w = qVar;
        this.f11096x = i;
    }

    private final Object c() {
        q qVar = this.f11095w;
        int i = this.f11096x;
        qVar.F.getClass();
        try {
            qVar.R.C(i, b.C);
            synchronized (qVar) {
                qVar.T.remove(Integer.valueOf(i));
            }
        } catch (IOException unused) {
        }
        return rd.l.f11003a;
    }

    private final Object d() {
        q qVar = this.f11095w;
        int i = this.f11096x;
        qVar.F.getClass();
        synchronized (qVar) {
            qVar.T.remove(Integer.valueOf(i));
        }
        return rd.l.f11003a;
    }

    @Override // fe.a
    public final Object b() {
        switch (this.f11094v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return c();
            case 1:
                return d();
            default:
                q qVar = this.f11095w;
                int i = this.f11096x;
                qVar.F.getClass();
                try {
                    qVar.R.C(i, b.C);
                    synchronized (qVar) {
                        qVar.T.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
                return rd.l.f11003a;
        }
    }

    public /* synthetic */ l(q qVar, int i, List list, boolean z10) {
        this.f11094v = 2;
        this.f11095w = qVar;
        this.f11096x = i;
    }
}
