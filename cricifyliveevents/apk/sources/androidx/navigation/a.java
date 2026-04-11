package androidx.navigation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends l {
    public Intent D;
    public String E;

    @Override // androidx.navigation.l
    public final void d(Context context, AttributeSet attributeSet) {
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, d0.ActivityNavigator);
        String string = typedArrayObtainAttributes.getString(d0.ActivityNavigator_targetPackage);
        if (string != null) {
            string = string.replace("${applicationId}", context.getPackageName());
        }
        if (this.D == null) {
            this.D = new Intent();
        }
        this.D.setPackage(string);
        String string2 = typedArrayObtainAttributes.getString(d0.ActivityNavigator_android_name);
        if (string2 != null) {
            if (string2.charAt(0) == '.') {
                string2 = context.getPackageName() + string2;
            }
            ComponentName componentName = new ComponentName(context, string2);
            if (this.D == null) {
                this.D = new Intent();
            }
            this.D.setComponent(componentName);
        }
        String string3 = typedArrayObtainAttributes.getString(d0.ActivityNavigator_action);
        if (this.D == null) {
            this.D = new Intent();
        }
        this.D.setAction(string3);
        String string4 = typedArrayObtainAttributes.getString(d0.ActivityNavigator_data);
        if (string4 != null) {
            Uri uri = Uri.parse(string4);
            if (this.D == null) {
                this.D = new Intent();
            }
            this.D.setData(uri);
        }
        this.E = typedArrayObtainAttributes.getString(d0.ActivityNavigator_dataPattern);
        typedArrayObtainAttributes.recycle();
    }

    @Override // androidx.navigation.l
    public final String toString() {
        Intent intent = this.D;
        ComponentName component = intent == null ? null : intent.getComponent();
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (component != null) {
            sb.append(" class=");
            sb.append(component.getClassName());
        } else {
            Intent intent2 = this.D;
            String action = intent2 != null ? intent2.getAction() : null;
            if (action != null) {
                sb.append(" action=");
                sb.append(action);
            }
        }
        return sb.toString();
    }
}
