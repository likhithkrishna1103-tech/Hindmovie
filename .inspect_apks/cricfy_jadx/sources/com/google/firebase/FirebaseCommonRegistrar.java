package com.google.firebase;

import a3.m;
import android.content.Context;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import fc.d;
import fc.e;
import fc.f;
import fc.g;
import hb.a;
import hb.b;
import hb.j;
import hb.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import nc.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        a aVarB = b.b(pc.b.class);
        aVarB.a(new j(2, 0, pc.a.class));
        aVarB.f5875g = new l(6);
        arrayList.add(aVarB.b());
        r rVar = new r(gb.a.class, Executor.class);
        a aVar = new a(d.class, new Class[]{f.class, g.class});
        aVar.a(j.b(Context.class));
        aVar.a(j.b(ab.g.class));
        aVar.a(new j(2, 0, e.class));
        aVar.a(new j(1, 1, pc.b.class));
        aVar.a(new j(rVar, 1, 0));
        aVar.f5875g = new fc.b(rVar, 0);
        arrayList.add(aVar.b());
        arrayList.add(vf.g.n("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(vf.g.n("fire-core", "22.0.1"));
        arrayList.add(vf.g.n("device-name", a(Build.PRODUCT)));
        arrayList.add(vf.g.n("device-model", a(Build.DEVICE)));
        arrayList.add(vf.g.n("device-brand", a(Build.BRAND)));
        arrayList.add(vf.g.C("android-target-sdk", new m(2)));
        arrayList.add(vf.g.C("android-min-sdk", new m(3)));
        arrayList.add(vf.g.C("android-platform", new m(4)));
        arrayList.add(vf.g.C("android-installer", new m(5)));
        try {
            rd.b.f10990w.getClass();
            str = "2.2.21";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(vf.g.n("kotlin", str));
        }
        return arrayList;
    }
}
