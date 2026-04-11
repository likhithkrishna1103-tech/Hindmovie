package ga;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import na.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements nb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5339c;

    public /* synthetic */ c(Context context, String str) {
        this.f5337a = 1;
        this.f5338b = context;
        this.f5339c = str;
    }

    @Override // nb.b
    public final Object get() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        switch (this.f5337a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) this.f5339c;
                Context contextA = (Context) this.f5338b;
                String strD = gVar.d();
                sb.a aVar = new sb.a();
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    contextA = i >= 24 ? f0.a.a(contextA) : null;
                }
                SharedPreferences sharedPreferences = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + strD, 0);
                boolean z2 = true;
                if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
                    z2 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
                } else {
                    try {
                        PackageManager packageManager = contextA.getPackageManager();
                        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextA.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                            z2 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                        }
                        break;
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                aVar.f11940a = z2;
                return aVar;
            case 1:
                return new u5.d((Context) this.f5338b, (String) this.f5339c);
            default:
                na.g gVar2 = (na.g) this.f5339c;
                na.b bVar = (na.b) this.f5338b;
                na.e eVar = bVar.f;
                zc.c cVar = new zc.c();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = new HashSet();
                HashSet hashSet5 = new HashSet();
                Set<na.j> set = bVar.f8881c;
                Set set2 = bVar.f8884g;
                for (na.j jVar : set) {
                    int i10 = jVar.f8901c;
                    int i11 = jVar.f8900b;
                    boolean z10 = i10 == 0;
                    r rVar = jVar.f8899a;
                    if (z10) {
                        if (i11 == 2) {
                            hashSet4.add(rVar);
                        } else {
                            hashSet.add(rVar);
                        }
                    } else if (i10 == 2) {
                        hashSet3.add(rVar);
                    } else if (i11 == 2) {
                        hashSet5.add(rVar);
                    } else {
                        hashSet2.add(rVar);
                    }
                }
                if (!set2.isEmpty()) {
                    hashSet.add(r.a(kb.b.class));
                }
                cVar.f14945u = Collections.unmodifiableSet(hashSet);
                cVar.f14946v = Collections.unmodifiableSet(hashSet2);
                cVar.f14947w = Collections.unmodifiableSet(hashSet3);
                cVar.f14948x = Collections.unmodifiableSet(hashSet4);
                Collections.unmodifiableSet(hashSet5);
                cVar.f14949y = gVar2;
                return eVar.e(cVar);
        }
    }

    public /* synthetic */ c(Object obj, int i, Object obj2) {
        this.f5337a = i;
        this.f5339c = obj;
        this.f5338b = obj2;
    }
}
