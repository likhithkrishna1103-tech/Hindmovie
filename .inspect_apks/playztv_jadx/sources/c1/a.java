package c1;

import ae.l;
import be.h;
import be.i;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f2230v = new a(1);

    @Override // ae.l
    public final Object a(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        h.e(entry, "entry");
        return "  " + ((d) entry.getKey()).f2235a + " = " + entry.getValue();
    }
}
