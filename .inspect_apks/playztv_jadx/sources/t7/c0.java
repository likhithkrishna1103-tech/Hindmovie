package t7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f12255d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12258c;

    public c0(String str, boolean z2) {
        v.d(str);
        this.f12256a = str;
        v.d("com.google.android.gms");
        this.f12257b = "com.google.android.gms";
        this.f12258c = z2;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        String str = this.f12256a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f12258c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(f12255d, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e10) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e10.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.f12257b) : intent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return v.k(this.f12256a, c0Var.f12256a) && v.k(this.f12257b, c0Var.f12257b) && v.k(null, null) && this.f12258c == c0Var.f12258c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12256a, this.f12257b, null, 4225, Boolean.valueOf(this.f12258c)});
    }

    public final String toString() {
        String str = this.f12256a;
        if (str != null) {
            return str;
        }
        v.h(null);
        throw null;
    }
}
