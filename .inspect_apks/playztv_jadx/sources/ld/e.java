package ld;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends HashMap {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ h f8136u;

    public e(h hVar) {
        this.f8136u = hVar;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        this.f8136u.f8148z.put(str == null ? str : str.toLowerCase(), str2);
        return (String) super.put(str, str2);
    }
}
