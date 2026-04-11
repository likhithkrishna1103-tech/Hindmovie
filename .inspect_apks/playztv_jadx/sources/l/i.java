package l;

import androidx.media3.decoder.DecoderInputBuffer;
import n.m3;
import q0.u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends z7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7798e;
    public final /* synthetic */ Object f;

    public i(j jVar) {
        this.f7796c = 0;
        this.f = jVar;
        this.f7797d = false;
        this.f7798e = 0;
    }

    @Override // q0.u0
    public final void a() {
        switch (this.f7796c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f7798e + 1;
                this.f7798e = i;
                j jVar = (j) this.f;
                if (i == jVar.f7799a.size()) {
                    u0 u0Var = jVar.f7802d;
                    if (u0Var != null) {
                        u0Var.a();
                    }
                    this.f7798e = 0;
                    this.f7797d = false;
                    jVar.f7803e = false;
                }
                break;
            default:
                if (!this.f7797d) {
                    ((m3) this.f).f8443a.setVisibility(this.f7798e);
                }
                break;
        }
    }

    @Override // z7.a, q0.u0
    public void b() {
        switch (this.f7796c) {
            case 1:
                this.f7797d = true;
                break;
        }
    }

    @Override // z7.a, q0.u0
    public final void c() {
        switch (this.f7796c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!this.f7797d) {
                    this.f7797d = true;
                    u0 u0Var = ((j) this.f).f7802d;
                    if (u0Var != null) {
                        u0Var.c();
                    }
                    break;
                }
                break;
            default:
                ((m3) this.f).f8443a.setVisibility(0);
                break;
        }
    }

    public i(m3 m3Var, int i) {
        this.f7796c = 1;
        this.f = m3Var;
        this.f7798e = i;
        this.f7797d = false;
    }
}
