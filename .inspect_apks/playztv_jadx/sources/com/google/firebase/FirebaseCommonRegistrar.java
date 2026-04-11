package com.google.firebase;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.c;
import com.google.firebase.components.ComponentRegistrar;
import g4.s0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import lb.d;
import lb.e;
import lb.f;
import lb.g;
import na.a;
import na.b;
import na.j;
import na.r;
import r2.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        a aVarA = b.a(wb.b.class);
        aVarA.a(new j(2, 0, wb.a.class));
        aVarA.f8878g = new h(15);
        arrayList.add(aVarA.b());
        r rVar = new r(ma.a.class, Executor.class);
        a aVar = new a(d.class, new Class[]{f.class, g.class});
        aVar.a(j.a(Context.class));
        aVar.a(j.a(ga.g.class));
        aVar.a(new j(2, 0, e.class));
        aVar.a(new j(1, 1, wb.b.class));
        aVar.a(new j(rVar, 1, 0));
        aVar.f8878g = new lb.b(rVar, 0);
        arrayList.add(aVar.b());
        arrayList.add(c.g("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(c.g("fire-core", "21.0.0"));
        arrayList.add(c.g("device-name", a(Build.PRODUCT)));
        arrayList.add(c.g("device-model", a(Build.DEVICE)));
        arrayList.add(c.g("device-brand", a(Build.BRAND)));
        arrayList.add(c.j("android-target-sdk", new s0(22)));
        arrayList.add(c.j("android-min-sdk", new s0(23)));
        arrayList.add(c.j("android-platform", new s0(24)));
        arrayList.add(c.j("android-installer", new s0(25)));
        try {
            nd.b.f8980v.getClass();
            str = "2.1.10";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(c.g("kotlin", str));
        }
        return arrayList;
    }
}
