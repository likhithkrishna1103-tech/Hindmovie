package g2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements y1.m, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f4948w;

    public /* synthetic */ y(int i, boolean z10) {
        this.f4947v = i;
        this.f4948w = z10;
    }

    @Override // y1.m
    public void a(Object obj) {
        switch (this.f4947v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((v1.u0) obj).E(this.f4948w);
                break;
            default:
                ((v1.u0) obj).b(this.f4948w);
                break;
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f4947v) {
            case 2:
                ((k4.h1) obj).j(this.f4948w);
                break;
            case 3:
                ((k4.h1) obj).i0(this.f4948w);
                break;
            default:
                ((k4.h1) obj).A(this.f4948w);
                break;
        }
    }
}
