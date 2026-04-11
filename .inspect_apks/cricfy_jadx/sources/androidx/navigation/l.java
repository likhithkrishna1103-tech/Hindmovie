package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public ArrayList A;
    public v.l B;
    public HashMap C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f1369v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public n f1370w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1371x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f1372y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f1373z;

    static {
        new HashMap();
    }

    public l(a0 a0Var) {
        this.f1369v = b0.b(a0Var.getClass());
    }

    public static String b(Context context, int i) {
        if (i <= 16777215) {
            return Integer.toString(i);
        }
        try {
            return context.getResources().getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i);
        }
    }

    public final Bundle a(Bundle bundle) {
        HashMap map;
        if (bundle == null && ((map = this.C) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap map2 = this.C;
        if (map2 != null) {
            for (Map.Entry entry : map2.entrySet()) {
                d dVar = (d) entry.getValue();
                String str = (String) entry.getKey();
                if (dVar.f1327c) {
                    dVar.f1325a.d(bundle2, str, dVar.f1328d);
                }
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap map3 = this.C;
            if (map3 != null) {
                for (Map.Entry entry2 : map3.entrySet()) {
                    d dVar2 = (d) entry2.getValue();
                    String str2 = (String) entry2.getKey();
                    if (dVar2.f1326b || !bundle2.containsKey(str2) || bundle2.get(str2) != null) {
                        try {
                            dVar2.f1325a.a(str2, bundle2);
                        } catch (ClassCastException unused) {
                        }
                    }
                    throw new IllegalArgumentException("Wrong argument type for '" + ((String) entry2.getKey()) + "' in argument bundle. " + ((d) entry2.getValue()).f1325a.b() + " expected.");
                }
            }
        }
        return bundle2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.navigation.k c(androidx.emoji2.text.v r21) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.l.c(androidx.emoji2.text.v):androidx.navigation.k");
    }

    public void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, n4.a.Navigator);
        int resourceId = typedArrayObtainAttributes.getResourceId(n4.a.Navigator_android_id, 0);
        this.f1371x = resourceId;
        this.f1372y = null;
        this.f1372y = b(context, resourceId);
        this.f1373z = typedArrayObtainAttributes.getText(n4.a.Navigator_android_label);
        typedArrayObtainAttributes.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.f1372y;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.f1371x));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.f1373z != null) {
            sb.append(" label=");
            sb.append(this.f1373z);
        }
        return sb.toString();
    }
}
