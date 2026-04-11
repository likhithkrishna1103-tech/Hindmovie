package l5;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7826a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f7827b;

    public /* synthetic */ s() {
    }

    @Override // l5.l
    public final void b(n nVar) {
        switch (this.f7826a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7827b.z();
                nVar.x(this);
                break;
            default:
                a aVar = (a) this.f7827b;
                int i = aVar.X - 1;
                aVar.X = i;
                if (i == 0) {
                    aVar.Y = false;
                    aVar.m();
                }
                nVar.x(this);
                break;
        }
    }

    @Override // l5.o, l5.l
    public void g(n nVar) {
        switch (this.f7826a) {
            case 1:
                a aVar = (a) this.f7827b;
                if (!aVar.Y) {
                    aVar.G();
                    aVar.Y = true;
                }
                break;
        }
    }

    public s(n nVar) {
        this.f7827b = nVar;
    }
}
