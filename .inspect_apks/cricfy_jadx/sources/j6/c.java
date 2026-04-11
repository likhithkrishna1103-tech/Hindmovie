package j6;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f6624v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t6.a f6626x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6627y = -1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public t6.a f6625w = a(0.0f);

    public c(List list) {
        this.f6624v = list;
    }

    public final t6.a a(float f) {
        List list = this.f6624v;
        t6.a aVar = (t6.a) list.get(list.size() - 1);
        if (f >= aVar.b()) {
            return aVar;
        }
        for (int size = list.size() - 2; size >= 1; size--) {
            t6.a aVar2 = (t6.a) list.get(size);
            if (this.f6625w != aVar2 && f >= aVar2.b() && f < aVar2.a()) {
                return aVar2;
            }
        }
        return (t6.a) list.get(0);
    }

    @Override // j6.b
    public final float b() {
        return ((t6.a) this.f6624v.get(r0.size() - 1)).a();
    }

    @Override // j6.b
    public final boolean c(float f) {
        t6.a aVar = this.f6626x;
        t6.a aVar2 = this.f6625w;
        if (aVar == aVar2 && this.f6627y == f) {
            return true;
        }
        this.f6626x = aVar2;
        this.f6627y = f;
        return false;
    }

    @Override // j6.b
    public final float d() {
        return ((t6.a) this.f6624v.get(0)).b();
    }

    @Override // j6.b
    public final t6.a e() {
        return this.f6625w;
    }

    @Override // j6.b
    public final boolean f(float f) {
        t6.a aVar = this.f6625w;
        if (f >= aVar.b() && f < aVar.a()) {
            return !this.f6625w.c();
        }
        this.f6625w = a(f);
        return true;
    }

    @Override // j6.b
    public final boolean isEmpty() {
        return false;
    }
}
