package vc;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements xc.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13686v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ma.e f13687w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final qd.a f13688x;

    public /* synthetic */ s(ma.e eVar, xc.c cVar, int i) {
        this.f13686v = i;
        this.f13687w = eVar;
        this.f13688x = cVar;
    }

    @Override // qd.a
    public final Object get() {
        switch (this.f13686v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Context context = (Context) this.f13687w.f8417v;
                vd.h hVar = (vd.h) this.f13688x.get();
                ge.i.e(context, "appContext");
                ge.i.e(hVar, "blockingDispatcher");
                return q.b(yc.h.f15039a, new e1.a(new b6.a(6)), pe.x.b(hVar), new p(context, 0));
            case 1:
                return new c0((Context) this.f13687w.f8417v, (f1) this.f13688x.get());
            default:
                return new yc.d((b) this.f13688x.get(), (vd.h) this.f13687w.f8417v);
        }
    }

    public s(xc.c cVar, ma.e eVar) {
        this.f13686v = 2;
        this.f13688x = cVar;
        this.f13687w = eVar;
    }
}
