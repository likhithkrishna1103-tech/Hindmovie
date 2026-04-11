package se;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11709v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ge.p f11710w;

    public /* synthetic */ r(ge.p pVar, int i) {
        this.f11709v = i;
        this.f11710w = pVar;
    }

    @Override // se.d
    public final Object f(Object obj, vd.c cVar) {
        switch (this.f11709v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f11710w.f5254v = obj;
                throw new te.a(this);
            default:
                this.f11710w.f5254v = obj;
                throw new te.a(this);
        }
    }
}
