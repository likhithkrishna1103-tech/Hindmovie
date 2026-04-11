package c;

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
import c.l;
import com.google.android.gms.internal.measurement.z3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1968a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1969b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1970c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1971d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f1972e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f1973g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h.j f1974h;

    public l(h.j jVar) {
        this.f1974h = jVar;
    }

    public final boolean a(int i, int i10, Intent intent) {
        String str = (String) this.f1968a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        e.e eVar = (e.e) this.f1972e.get(str);
        if ((eVar != null ? eVar.f3739a : null) != null) {
            ArrayList arrayList = this.f1971d;
            if (arrayList.contains(str)) {
                eVar.f3739a.i(eVar.f3740b.m(intent, i10));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.f1973g.putParcelable(str, new e.a(intent, i10));
        return true;
    }

    public final void b(int i, t1 t1Var, Object obj) {
        Bundle bundleExtra;
        int i10;
        h.j jVar = this.f1974h;
        pc.c cVarI = t1Var.i(jVar, obj);
        if (cVarI != null) {
            new Handler(Looper.getMainLooper()).post(new k(this, i, cVarI, 0));
            return;
        }
        Intent intentD = t1Var.d(jVar, obj);
        if (intentD.getExtras() != null) {
            Bundle extras = intentD.getExtras();
            ge.i.b(extras);
            if (extras.getClassLoader() == null) {
                intentD.setExtrasClassLoader(jVar.getClassLoader());
            }
        }
        if (intentD.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentD.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentD.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentD.getAction())) {
            String[] stringArrayExtra = intentD.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < stringArrayExtra.length; i11++) {
                if (TextUtils.isEmpty(stringArrayExtra[i11])) {
                    throw new IllegalArgumentException(q4.a.q(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
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
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentD.getAction())) {
            jVar.startActivityForResult(intentD, i, bundle);
            return;
        }
        e.h hVar = (e.h) intentD.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            ge.i.b(hVar);
            i10 = i;
            try {
                jVar.startIntentSenderForResult(hVar.f3747v, i10, hVar.f3748w, hVar.f3749x, hVar.f3750y, 0, bundle);
            } catch (IntentSender.SendIntentException e9) {
                e = e9;
                new Handler(Looper.getMainLooper()).post(new k(this, i10, e, 1));
            }
        } catch (IntentSender.SendIntentException e10) {
            e = e10;
            i10 = i;
        }
    }

    public final e.g c(final String str, androidx.lifecycle.s sVar, final t1 t1Var, final e.b bVar) {
        ge.i.e(str, "key");
        androidx.lifecycle.u uVarF = sVar.f();
        if (uVarF.f1200c.compareTo(androidx.lifecycle.n.f1182y) >= 0) {
            throw new IllegalStateException(("LifecycleOwner " + sVar + " is attempting to register while current state is " + uVarF.f1200c + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        e(str);
        LinkedHashMap linkedHashMap = this.f1970c;
        e.f fVar = (e.f) linkedHashMap.get(str);
        if (fVar == null) {
            fVar = new e.f(uVarF);
        }
        androidx.lifecycle.q qVar = new androidx.lifecycle.q() { // from class: e.d
            @Override // androidx.lifecycle.q
            public final void a(s sVar2, m mVar) {
                l lVar = this.f3735v;
                LinkedHashMap linkedHashMap2 = lVar.f1972e;
                m mVar2 = m.ON_START;
                String str2 = str;
                if (mVar2 != mVar) {
                    if (m.ON_STOP == mVar) {
                        linkedHashMap2.remove(str2);
                        return;
                    } else {
                        if (m.ON_DESTROY == mVar) {
                            lVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                Bundle bundle = lVar.f1973g;
                LinkedHashMap linkedHashMap3 = lVar.f;
                b bVar2 = bVar;
                t1 t1Var2 = t1Var;
                linkedHashMap2.put(str2, new e(bVar2, t1Var2));
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    bVar2.i(obj);
                }
                a aVar = (a) z3.m(str2, bundle);
                if (aVar != null) {
                    bundle.remove(str2);
                    bVar2.i(t1Var2.m(aVar.f3734w, aVar.f3733v));
                }
            }
        };
        fVar.f3741a.a(qVar);
        fVar.f3742b.add(qVar);
        linkedHashMap.put(str, fVar);
        return new e.g(this, str, t1Var, 0);
    }

    public final e.g d(String str, t1 t1Var, e.b bVar) {
        ge.i.e(str, "key");
        e(str);
        this.f1972e.put(str, new e.e(bVar, t1Var));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            bVar.i(obj);
        }
        Bundle bundle = this.f1973g;
        e.a aVar = (e.a) z3.m(str, bundle);
        if (aVar != null) {
            bundle.remove(str);
            bVar.i(t1Var.m(aVar.f3734w, aVar.f3733v));
        }
        return new e.g(this, str, t1Var, 1);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.f1969b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        x xVar = new x(2);
        for (Number number : new me.a(new me.d(xVar, new df.l(2, xVar), 0))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.f1968a;
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
        ge.i.e(str, "key");
        if (!this.f1971d.contains(str) && (num = (Integer) this.f1969b.remove(str)) != null) {
            this.f1968a.remove(num);
        }
        this.f1972e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + linkedHashMap.get(str));
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.f1973g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((e.a) z3.m(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.f1970c;
        e.f fVar = (e.f) linkedHashMap2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f3742b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                fVar.f3741a.f((androidx.lifecycle.q) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
