package androidx.fragment.app;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.j f943b;

    public /* synthetic */ b0(h.j jVar, int i) {
        this.f942a = i;
        this.f943b = jVar;
    }

    @Override // d.a
    public final void a(c.m mVar) {
        switch (this.f942a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c0 c0Var = (c0) this.f943b.Q.f10180v;
                c0Var.f954z.b(c0Var, c0Var, null);
                return;
            default:
                ge.i.e(mVar, "it");
                h.j jVar = this.f943b;
                Bundle bundleC = ((b5.e) jVar.f1977y.f2291x).c("android:support:activity-result");
                if (bundleC != null) {
                    c.l lVar = jVar.D;
                    LinkedHashMap linkedHashMap = lVar.f1969b;
                    LinkedHashMap linkedHashMap2 = lVar.f1968a;
                    Bundle bundle = lVar.f1973g;
                    ArrayList<Integer> integerArrayList = bundleC.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleC.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    ArrayList<String> stringArrayList2 = bundleC.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if (stringArrayList2 != null) {
                        lVar.f1971d.addAll(stringArrayList2);
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
                                if ((linkedHashMap2 instanceof he.a) && !(linkedHashMap2 instanceof he.b)) {
                                    ge.s.e(linkedHashMap2, "kotlin.collections.MutableMap");
                                    throw null;
                                }
                                linkedHashMap2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i);
                        ge.i.d(num2, "get(...)");
                        int iIntValue = num2.intValue();
                        String str2 = stringArrayList.get(i);
                        ge.i.d(str2, "get(...)");
                        String str3 = str2;
                        linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                        lVar.f1969b.put(str3, Integer.valueOf(iIntValue));
                    }
                    return;
                }
                return;
        }
    }
}
