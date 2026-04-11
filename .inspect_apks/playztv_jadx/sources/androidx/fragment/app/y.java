package androidx.fragment.app;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.j f1418b;

    public /* synthetic */ y(h.j jVar, int i) {
        this.f1417a = i;
        this.f1418b = jVar;
    }

    @Override // d.a
    public final void a(c.l lVar) {
        switch (this.f1417a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z zVar = (z) this.f1418b.P.f14088v;
                zVar.f1425x.b(zVar, zVar, null);
                return;
            default:
                be.h.e(lVar, "it");
                h.j jVar = this.f1418b;
                Bundle bundleC = ((n.s) jVar.f2184x.f2861v).c("android:support:activity-result");
                if (bundleC != null) {
                    c.k kVar = jVar.C;
                    LinkedHashMap linkedHashMap = kVar.f2176b;
                    LinkedHashMap linkedHashMap2 = kVar.f2175a;
                    Bundle bundle = kVar.f2180g;
                    ArrayList<Integer> integerArrayList = bundleC.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleC.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    ArrayList<String> stringArrayList2 = bundleC.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if (stringArrayList2 != null) {
                        kVar.f2178d.addAll(stringArrayList2);
                    }
                    Bundle bundle2 = bundleC.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    if (bundle2 != null) {
                        bundle.putAll(bundle2);
                    }
                    int size = stringArrayList.size();
                    for (int i = 0; i < size; i++) {
                        String str = stringArrayList.get(i);
                        if (linkedHashMap.containsKey(str)) {
                            Integer num = (Integer) linkedHashMap.remove(str);
                            if (bundle.containsKey(str)) {
                                continue;
                            } else {
                                if ((linkedHashMap2 instanceof ce.a) && !(linkedHashMap2 instanceof ce.b)) {
                                    be.q.c(linkedHashMap2, "kotlin.collections.MutableMap");
                                    throw null;
                                }
                                linkedHashMap2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i);
                        be.h.d(num2, "get(...)");
                        int iIntValue = num2.intValue();
                        String str2 = stringArrayList.get(i);
                        be.h.d(str2, "get(...)");
                        String str3 = str2;
                        linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                        kVar.f2176b.put(str3, Integer.valueOf(iIntValue));
                    }
                    return;
                }
                return;
        }
    }
}
