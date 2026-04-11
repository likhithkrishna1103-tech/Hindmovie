package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f1322b;

    @Override // androidx.navigation.a0
    public final l a() {
        return new a(this);
    }

    @Override // androidx.navigation.a0
    public final l b(l lVar, Bundle bundle, r rVar) {
        Intent intent;
        int intExtra;
        a aVar = (a) lVar;
        Activity activity = this.f1322b;
        Context context = this.f1321a;
        if (aVar.D == null) {
            throw new IllegalStateException(q4.a.o(new StringBuilder("Destination "), aVar.f1371x, " does not have an Intent set."));
        }
        Intent intent2 = new Intent(aVar.D);
        if (bundle != null) {
            intent2.putExtras(bundle);
            String str = aVar.E;
            if (!TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (!bundle.containsKey(strGroup)) {
                        throw new IllegalArgumentException("Could not find " + strGroup + " in " + bundle + " to fill data pattern " + str);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(bundle.get(strGroup).toString()));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        if (!(context instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar.f1371x);
        context.getResources();
        if (rVar != null) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", -1);
            intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", -1);
        }
        context.startActivity(intent2);
        if (rVar == null || activity == null) {
            return null;
        }
        activity.overridePendingTransition(Math.max(0, 0), Math.max(0, 0));
        return null;
    }

    @Override // androidx.navigation.a0
    public final boolean e() {
        Activity activity = this.f1322b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
