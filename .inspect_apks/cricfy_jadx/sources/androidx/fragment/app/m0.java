package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends t1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1022b;

    public /* synthetic */ m0(int i) {
        this.f1022b = i;
    }

    @Override // qb.t1
    public final Intent d(h.j jVar, Object obj) {
        Bundle bundleExtra;
        switch (this.f1022b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e.h hVar = (e.h) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = hVar.f3748w;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        hVar = new e.h(hVar.f3747v, null, hVar.f3749x, hVar.f3750y);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", hVar);
                if (r0.J(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] strArr = (String[]) obj;
                ge.i.e(strArr, "input");
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                ge.i.d(intentPutExtra, "putExtra(...)");
                return intentPutExtra;
            case 2:
                String str = (String) obj;
                ge.i.e(str, "input");
                Intent intentPutExtra2 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{str});
                ge.i.d(intentPutExtra2, "putExtra(...)");
                return intentPutExtra2;
            default:
                Intent intent3 = (Intent) obj;
                ge.i.e(intent3, "input");
                return intent3;
        }
    }

    @Override // qb.t1
    public pc.c i(h.j jVar, Object obj) {
        switch (this.f1022b) {
            case 1:
                String[] strArr = (String[]) obj;
                ge.i.e(strArr, "input");
                if (strArr.length == 0) {
                    return new pc.c(sd.q.f11670v);
                }
                for (String str : strArr) {
                    if (i0.c.a(jVar, str) != 0) {
                        return null;
                    }
                }
                int iA = sd.s.A(strArr.length);
                if (iA < 16) {
                    iA = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iA);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new pc.c(linkedHashMap);
            case 2:
                String str3 = (String) obj;
                ge.i.e(str3, "input");
                if (i0.c.a(jVar, str3) == 0) {
                    return new pc.c(Boolean.TRUE);
                }
                return null;
            default:
                return super.i(jVar, obj);
        }
    }

    @Override // qb.t1
    public final Object m(Intent intent, int i) {
        switch (this.f1022b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new e.a(intent, i);
            case 1:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i10 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i10 == 0));
                        }
                        ArrayList arrayListQ = sd.i.q(stringArrayExtra);
                        Iterator it = arrayListQ.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList2 = new ArrayList(Math.min(sd.l.f0(arrayListQ, 10), sd.l.f0(arrayList, 10)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList2.add(new rd.f(it.next(), it2.next()));
                        }
                        return sd.s.B(arrayList2);
                    }
                }
                return sd.q.f11670v;
            case 2:
                if (intent == null || i != -1) {
                    return Boolean.FALSE;
                }
                int[] intArrayExtra2 = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                boolean z10 = false;
                if (intArrayExtra2 != null) {
                    int length = intArrayExtra2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length) {
                            if (intArrayExtra2[i11] == 0) {
                                z10 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z10);
            default:
                return new e.a(intent, i);
        }
    }
}
