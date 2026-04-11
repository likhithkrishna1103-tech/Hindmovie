package j6;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t6.a f6628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6629w = -1.0f;

    public d(List list) {
        this.f6628v = (t6.a) list.get(0);
    }

    @Override // j6.b
    public final float b() {
        return this.f6628v.a();
    }

    @Override // j6.b
    public final boolean c(float f) {
        if (this.f6629w == f) {
            return true;
        }
        this.f6629w = f;
        return false;
    }

    @Override // j6.b
    public final float d() {
        return this.f6628v.b();
    }

    @Override // j6.b
    public final t6.a e() {
        return this.f6628v;
    }

    @Override // j6.b
    public final boolean f(float f) {
        return !this.f6628v.c();
    }

    @Override // j6.b
    public final boolean isEmpty() {
        return false;
    }
}
