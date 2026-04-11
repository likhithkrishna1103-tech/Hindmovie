package pd;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends HashMap {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f f10196v;

    public c(f fVar) {
        this.f10196v = fVar;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        this.f10196v.A.put(str == null ? str : str.toLowerCase(), str2);
        return (String) super.put(str, str2);
    }
}
