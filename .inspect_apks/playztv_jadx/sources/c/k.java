package c;

import a2.n1;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.m;
import androidx.lifecycle.s;
import c.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2175a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2176b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2177c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f2178d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f2179e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f2180g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h.j f2181h;

    public k(h.j jVar) {
        this.f2181h = jVar;
    }

    public final boolean a(int i, int i10, Intent intent) {
        String str = (String) this.f2175a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        e.e eVar = (e.e) this.f2179e.get(str);
        if ((eVar != null ? eVar.f4219a : null) != null) {
            ArrayList arrayList = this.f2178d;
            if (arrayList.contains(str)) {
                eVar.f4219a.j(eVar.f4220b.v(intent, i10));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.f2180g.putParcelable(str, new e.a(intent, i10));
        return true;
    }

    public final void b(int i, cf.d dVar, Object obj) {
        Bundle bundleExtra;
        int i10;
        h.j jVar = this.f2181h;
        u5.c cVarP = dVar.p(jVar, obj);
        if (cVarP != null) {
            new Handler(Looper.getMainLooper()).post(new n1(this, i, cVarP, 1));
            return;
        }
        Intent intentK = dVar.k(jVar, obj);
        if (intentK.getExtras() != null) {
            Bundle extras = intentK.getExtras();
            be.h.b(extras);
            if (extras.getClassLoader() == null) {
                intentK.setExtrasClassLoader(jVar.getClassLoader());
            }
        }
        if (intentK.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentK.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentK.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentK.getAction())) {
            String[] stringArrayExtra = intentK.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < stringArrayExtra.length; i11++) {
                if (TextUtils.isEmpty(stringArrayExtra[i11])) {
                    throw new IllegalArgumentException(l4.a.o(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i11], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i11));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i12 = 0;
                for (int i13 = 0; i13 < stringArrayExtra.length; i13++) {
                    if (!hashSet.contains(Integer.valueOf(i13))) {
                        strArr[i12] = stringArrayExtra[i13];
                        i12++;
                    }
                }
            }
            jVar.requestPermissions(stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentK.getAction())) {
            jVar.startActivityForResult(intentK, i, bundle);
            return;
        }
        e.h hVar = (e.h) intentK.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            be.h.b(hVar);
            i10 = i;
            try {
                jVar.startIntentSenderForResult(hVar.f4227u, i10, hVar.f4228v, hVar.f4229w, hVar.f4230x, 0, bundle);
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                new Handler(Looper.getMainLooper()).post(new n1(this, i10, e, 2));
            }
        } catch (IntentSender.SendIntentException e11) {
            e = e11;
            i10 = i;
        }
    }

    public final e.g c(final String str, androidx.lifecycle.s sVar, final cf.d dVar, final e.b bVar) {
        be.h.e(str, "key");
        androidx.lifecycle.u uVarF = sVar.f();
        if (uVarF.f1504c.compareTo(androidx.lifecycle.n.f1485x) >= 0) {
            throw new IllegalStateException(("LifecycleOwner " + sVar + " is attempting to register while current state is " + uVarF.f1504c + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        e(str);
        LinkedHashMap linkedHashMap = this.f2177c;
        e.f fVar = (e.f) linkedHashMap.get(str);
        if (fVar == null) {
            fVar = new e.f(uVarF);
        }
        androidx.lifecycle.q qVar = new androidx.lifecycle.q() { // from class: e.d
            @Override // androidx.lifecycle.q
            public final void a(s sVar2, m mVar) {
                k kVar = this.f4215u;
                LinkedHashMap linkedHashMap2 = kVar.f2179e;
                m mVar2 = m.ON_START;
                String str2 = str;
                if (mVar2 != mVar) {
                    if (m.ON_STOP == mVar) {
                        linkedHashMap2.remove(str2);
                        return;
                    } else {
                        if (m.ON_DESTROY == mVar) {
                            kVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                Bundle bundle = kVar.f2180g;
                LinkedHashMap linkedHashMap3 = kVar.f;
                cf.d dVar2 = dVar;
                b bVar2 = bVar;
                linkedHashMap2.put(str2, new e(dVar2, bVar2));
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    bVar2.j(obj);
                }
                a aVar = (a) ga.b.s(str2, bundle);
                if (aVar != null) {
                    bundle.remove(str2);
                    bVar2.j(dVar2.v(aVar.f4214v, aVar.f4213u));
                }
            }
        };
        fVar.f4221a.a(qVar);
        fVar.f4222b.add(qVar);
        linkedHashMap.put(str, fVar);
        return new e.g(this, str, dVar, 0);
    }

    public final e.g d(String str, cf.d dVar, e.b bVar) {
        be.h.e(str, "key");
        e(str);
        this.f2179e.put(str, new e.e(dVar, bVar));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            bVar.j(obj);
        }
        Bundle bundle = this.f2180g;
        e.a aVar = (e.a) ga.b.s(str, bundle);
        if (aVar != null) {
            bundle.remove(str);
            bVar.j(dVar.v(aVar.f4214v, aVar.f4213u));
        }
        return new e.g(this, str, dVar, 1);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.f2176b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        a5.c cVar = new a5.c(3);
        for (Number number : new he.a(new he.d(cVar, new he.i(0, cVar), 0))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.f2175a;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String str) {
        Integer num;
        be.h.e(str, "key");
        if (!this.f2178d.contains(str) && (num = (Integer) this.f2176b.remove(str)) != null) {
            this.f2175a.remove(num);
        }
        this.f2179e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + linkedHashMap.get(str));
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.f2180g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((e.a) ga.b.s(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.f2177c;
        e.f fVar = (e.f) linkedHashMap2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f4222b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                fVar.f4221a.f((androidx.lifecycle.q) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
