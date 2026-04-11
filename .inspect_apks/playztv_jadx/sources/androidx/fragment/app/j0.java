package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends cf.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1292d;

    public /* synthetic */ j0(int i) {
        this.f1292d = i;
    }

    @Override // cf.d
    public final Intent k(h.j jVar, Object obj) {
        Bundle bundleExtra;
        switch (this.f1292d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e.h hVar = (e.h) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = hVar.f4228v;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        hVar = new e.h(hVar.f4227u, null, hVar.f4229w, hVar.f4230x);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", hVar);
                if (n0.G(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] strArr = (String[]) obj;
                be.h.e(strArr, "input");
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                be.h.d(intentPutExtra, "putExtra(...)");
                return intentPutExtra;
            case 2:
                String str = (String) obj;
                be.h.e(str, "input");
                Intent intentPutExtra2 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{str});
                be.h.d(intentPutExtra2, "putExtra(...)");
                return intentPutExtra2;
            default:
                Intent intent3 = (Intent) obj;
                be.h.e(intent3, "input");
                return intent3;
        }
    }

    @Override // cf.d
    public u5.c p(h.j jVar, Object obj) {
        switch (this.f1292d) {
            case 1:
                String[] strArr = (String[]) obj;
                be.h.e(strArr, "input");
                if (strArr.length == 0) {
                    return new u5.c(12, od.r.f9571u);
                }
                for (String str : strArr) {
                    if (f0.c.a(jVar, str) != 0) {
                        return null;
                    }
                }
                int iH = od.t.H(strArr.length);
                if (iH < 16) {
                    iH = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iH);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new u5.c(12, linkedHashMap);
            case 2:
                String str3 = (String) obj;
                be.h.e(str3, "input");
                if (f0.c.a(jVar, str3) != 0) {
                    return null;
                }
                return new u5.c(12, Boolean.TRUE);
            default:
                return super.p(jVar, obj);
        }
    }

    @Override // cf.d
    public final Object v(Intent intent, int i) {
        switch (this.f1292d) {
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
                        ArrayList arrayListX = od.h.X(stringArrayExtra);
                        Iterator it = arrayListX.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList2 = new ArrayList(Math.min(od.k.U(arrayListX), od.k.U(arrayList)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList2.add(new nd.f(it.next(), it2.next()));
                        }
                        return od.t.I(arrayList2);
                    }
                }
                return od.r.f9571u;
            case 2:
                if (intent == null || i != -1) {
                    return Boolean.FALSE;
                }
                int[] intArrayExtra2 = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                boolean z2 = false;
                if (intArrayExtra2 != null) {
                    int length = intArrayExtra2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length) {
                            if (intArrayExtra2[i11] == 0) {
                                z2 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z2);
            default:
                return new e.a(intent, i);
        }
    }
}
