package ua;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends m implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12324v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f12325w;

    public e0(Object obj, Object obj2) {
        this.f12324v = obj;
        this.f12325w = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f12324v;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f12325w;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
