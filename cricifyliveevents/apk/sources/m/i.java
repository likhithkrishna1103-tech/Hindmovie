package m;

import androidx.media3.decoder.DecoderInputBuffer;
import o.p3;
import t0.r0;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends v {
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8012l;

    public i(j jVar) {
        this.i = 0;
        this.f8012l = jVar;
        this.f8010j = false;
        this.f8011k = 0;
    }

    @Override // t0.r0
    public final void a() {
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f8011k + 1;
                this.f8011k = i;
                j jVar = (j) this.f8012l;
                if (i == jVar.f8013a.size()) {
                    r0 r0Var = jVar.f8016d;
                    if (r0Var != null) {
                        r0Var.a();
                    }
                    this.f8011k = 0;
                    this.f8010j = false;
                    jVar.f8017e = false;
                }
                break;
            default:
                if (!this.f8010j) {
                    ((p3) this.f8012l).f9308a.setVisibility(this.f8011k);
                }
                break;
        }
    }

    @Override // w4.v, t0.r0
    public void b() {
        switch (this.i) {
            case 1:
                this.f8010j = true;
                break;
        }
    }

    @Override // w4.v, t0.r0
    public final void c() {
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!this.f8010j) {
                    this.f8010j = true;
                    r0 r0Var = ((j) this.f8012l).f8016d;
                    if (r0Var != null) {
                        r0Var.c();
                    }
                    break;
                }
                break;
            default:
                ((p3) this.f8012l).f9308a.setVisibility(0);
                break;
        }
    }

    public i(p3 p3Var, int i) {
        this.i = 1;
        this.f8012l = p3Var;
        this.f8011k = i;
        this.f8010j = false;
    }
}
