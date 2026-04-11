package a2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements s1.m, s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f184u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f185v;

    public /* synthetic */ d0(int i, boolean z2) {
        this.f184u = i;
        this.f185v = z2;
    }

    @Override // s1.m
    public void a(Object obj) {
        switch (this.f184u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p1.u0) obj).G(this.f185v);
                break;
            default:
                ((p1.u0) obj).a(this.f185v);
                break;
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f184u) {
            case 2:
                ((g4.j1) obj).m(this.f185v);
                break;
            case 3:
                ((g4.j1) obj).k0(this.f185v);
                break;
            default:
                ((g4.j1) obj).G(this.f185v);
                break;
        }
    }
}
