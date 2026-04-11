package t5;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.n;
import com.bumptech.glide.p;
import o7.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p {
    @Override // com.bumptech.glide.p
    public final n h(Class cls) {
        return new b(this.f2295v, this, cls, this.f2296w);
    }

    @Override // com.bumptech.glide.p
    public final n i() {
        return (b) super.i();
    }

    @Override // com.bumptech.glide.p
    public final n n() {
        return (b) h(Drawable.class);
    }

    @Override // com.bumptech.glide.p
    public final n q(String str) {
        return (b) super.q(str);
    }

    @Override // com.bumptech.glide.p
    public final void t(g gVar) {
        if (gVar instanceof a) {
            super.t(gVar);
        } else {
            super.t(new a().x(gVar));
        }
    }
}
