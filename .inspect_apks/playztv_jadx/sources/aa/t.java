package aa;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f744u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f745v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ u f746w;

    public t(u uVar, int i) {
        this.f746w = uVar;
        Object obj = u.D;
        this.f744u = uVar.i()[i];
        this.f745v = i;
    }

    public final void a() {
        int i = this.f745v;
        Object obj = this.f744u;
        u uVar = this.f746w;
        if (i != -1 && i < uVar.size()) {
            if (i5.a.o(obj, uVar.i()[this.f745v])) {
                return;
            }
        }
        Object obj2 = u.D;
        this.f745v = uVar.d(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f744u;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        u uVar = this.f746w;
        Map mapB = uVar.b();
        if (mapB != null) {
            return mapB.get(this.f744u);
        }
        a();
        int i = this.f745v;
        if (i == -1) {
            return null;
        }
        return uVar.j()[i];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        u uVar = this.f746w;
        Map mapB = uVar.b();
        Object obj2 = this.f744u;
        if (mapB != null) {
            return mapB.put(obj2, obj);
        }
        a();
        int i = this.f745v;
        if (i == -1) {
            uVar.put(obj2, obj);
            return null;
        }
        Object obj3 = uVar.j()[i];
        uVar.j()[this.f745v] = obj;
        return obj3;
    }
}
