package ua;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12391v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12392w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ u f12393x;

    public t(u uVar, int i) {
        this.f12393x = uVar;
        Object obj = u.E;
        this.f12391v = uVar.i()[i];
        this.f12392w = i;
    }

    public final void a() {
        int i = this.f12392w;
        Object obj = this.f12391v;
        u uVar = this.f12393x;
        if (i != -1 && i < uVar.size()) {
            if (com.bumptech.glide.c.h(obj, uVar.i()[this.f12392w])) {
                return;
            }
        }
        Object obj2 = u.E;
        this.f12392w = uVar.d(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f12391v;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        u uVar = this.f12393x;
        Map mapB = uVar.b();
        if (mapB != null) {
            return mapB.get(this.f12391v);
        }
        a();
        int i = this.f12392w;
        if (i == -1) {
            return null;
        }
        return uVar.j()[i];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        u uVar = this.f12393x;
        Map mapB = uVar.b();
        Object obj2 = this.f12391v;
        if (mapB != null) {
            return mapB.put(obj2, obj);
        }
        a();
        int i = this.f12392w;
        if (i == -1) {
            uVar.put(obj2, obj);
            return null;
        }
        Object obj3 = uVar.j()[i];
        uVar.j()[this.f12392w] = obj;
        return obj3;
    }
}
