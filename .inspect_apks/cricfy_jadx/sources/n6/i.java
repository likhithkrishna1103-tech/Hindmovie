package n6;

import androidx.media3.decoder.DecoderInputBuffer;
import g6.w;
import i6.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8814a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6.b f8816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m6.f f8818e;
    public final Object f;

    public i(String str, m6.b bVar, m6.b bVar2, m6.e eVar, boolean z10) {
        this.f8815b = str;
        this.f8816c = bVar;
        this.f8818e = bVar2;
        this.f = eVar;
        this.f8817d = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        switch (this.f8814a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new i6.p(wVar, aVar, this);
            default:
                return new q(wVar, aVar, this);
        }
    }

    public String toString() {
        switch (this.f8814a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "RectangleShape{position=" + this.f8818e + ", size=" + ((m6.f) this.f) + '}';
            default:
                return super.toString();
        }
    }

    public i(String str, m6.f fVar, m6.a aVar, m6.b bVar, boolean z10) {
        this.f8815b = str;
        this.f8818e = fVar;
        this.f = aVar;
        this.f8816c = bVar;
        this.f8817d = z10;
    }
}
