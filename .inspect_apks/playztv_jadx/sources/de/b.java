package de;

import b8.j;
import be.h;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f4188v = new j(1);

    @Override // de.a
    public final Random a() {
        Object obj = this.f4188v.get();
        h.d(obj, "get(...)");
        return (Random) obj;
    }
}
