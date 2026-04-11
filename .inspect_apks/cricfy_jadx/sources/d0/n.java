package d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f3198d = {0, 4, 8};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f3199e;
    public static final SparseIntArray f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3200a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3201b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3202c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3199e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f = sparseIntArray2;
        sparseIntArray.append(r.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(r.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(r.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(r.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(r.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(r.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(r.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(r.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(r.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(r.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(r.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(r.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(r.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(r.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(r.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(r.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(r.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(r.Constraint_android_orientation, 27);
        sparseIntArray.append(r.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(r.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(r.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(r.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(r.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(r.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(r.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(r.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(r.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(r.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(r.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(r.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(r.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(r.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(r.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(r.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(r.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(r.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(r.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(r.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(r.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(r.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(r.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(r.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(r.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(r.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(r.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(r.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(r.Constraint_android_layout_width, 23);
        sparseIntArray.append(r.Constraint_android_layout_height, 21);
        sparseIntArray.append(r.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(r.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(r.Constraint_android_visibility, 22);
        sparseIntArray.append(r.Constraint_android_alpha, 43);
        sparseIntArray.append(r.Constraint_android_elevation, 44);
        sparseIntArray.append(r.Constraint_android_rotationX, 45);
        sparseIntArray.append(r.Constraint_android_rotationY, 46);
        sparseIntArray.append(r.Constraint_android_rotation, 60);
        sparseIntArray.append(r.Constraint_android_scaleX, 47);
        sparseIntArray.append(r.Constraint_android_scaleY, 48);
        sparseIntArray.append(r.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(r.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(r.Constraint_android_translationX, 51);
        sparseIntArray.append(r.Constraint_android_translationY, 52);
        sparseIntArray.append(r.Constraint_android_translationZ, 53);
        sparseIntArray.append(r.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(r.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(r.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(r.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(r.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(r.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(r.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(r.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(r.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(r.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(r.Constraint_transitionEasing, 65);
        sparseIntArray.append(r.Constraint_drawPath, 66);
        sparseIntArray.append(r.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(r.Constraint_motionStagger, 79);
        sparseIntArray.append(r.Constraint_android_id, 38);
        sparseIntArray.append(r.Constraint_motionProgress, 68);
        sparseIntArray.append(r.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(r.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(r.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(r.Constraint_chainUseRtl, 71);
        sparseIntArray.append(r.Constraint_barrierDirection, 72);
        sparseIntArray.append(r.Constraint_barrierMargin, 73);
        sparseIntArray.append(r.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(r.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(r.Constraint_pathMotionArc, 76);
        sparseIntArray.append(r.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(r.Constraint_visibilityMode, 78);
        sparseIntArray.append(r.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(r.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(r.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(r.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(r.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(r.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(r.Constraint_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(r.ConstraintOverride_layout_editor_absoluteY, 6);
        sparseIntArray2.append(r.ConstraintOverride_layout_editor_absoluteY, 7);
        sparseIntArray2.append(r.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(r.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(r.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(r.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(r.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(r.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(r.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(r.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(r.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(r.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(r.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(r.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(r.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(r.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(r.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(r.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(r.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(r.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(r.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(r.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(r.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(r.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(r.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(r.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(r.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(r.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(r.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(r.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(r.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(r.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(r.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(r.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(r.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(r.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(r.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(r.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(r.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(r.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(r.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(r.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(r.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(r.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(r.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(r.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(r.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int[] c(a aVar, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i10 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = q.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) aVar.getParent();
                if (q4.a.v(strTrim)) {
                    HashMap map = constraintLayout.H;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.H.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i10] = iIntValue;
            i++;
            i10++;
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    public static i d(Context context, AttributeSet attributeSet, boolean z10) {
        int i;
        int i10;
        i iVar = new i();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? r.ConstraintOverride : r.Constraint);
        l lVar = iVar.f3131b;
        m mVar = iVar.f3134e;
        k kVar = iVar.f3132c;
        j jVar = iVar.f3133d;
        int[] iArr = f3198d;
        String[] strArr = z.a.f15057a;
        SparseIntArray sparseIntArray = f3199e;
        if (z10) {
            h hVar = new h();
            hVar.f3120a = new int[10];
            hVar.f3121b = new int[10];
            hVar.f3122c = 0;
            hVar.f3123d = new int[10];
            hVar.f3124e = new float[10];
            hVar.f = 0;
            hVar.f3125g = new int[5];
            hVar.f3126h = new String[5];
            hVar.i = 0;
            hVar.f3127j = new int[4];
            hVar.f3128k = new boolean[4];
            hVar.f3129l = 0;
            kVar.getClass();
            jVar.getClass();
            mVar.getClass();
            int i11 = 0;
            for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i11 < indexCount; indexCount = i10) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                int i12 = i11;
                switch (f.get(index)) {
                    case 2:
                        i10 = indexCount;
                        hVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.I));
                        continue;
                        i11 = i12 + 1;
                        break;
                    case 3:
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder("Unknown attribute 0x");
                        i10 = indexCount;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        i10 = indexCount;
                        hVar.c(5, typedArrayObtainStyledAttributes.getString(index));
                        continue;
                        i11 = i12 + 1;
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        i10 = indexCount;
                        hVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.C));
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        i10 = indexCount;
                        hVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.D));
                        break;
                    case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                        i10 = indexCount;
                        hVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.J));
                        break;
                    case 11:
                        i10 = indexCount;
                        hVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.P));
                        break;
                    case 12:
                        i10 = indexCount;
                        hVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.Q));
                        break;
                    case 13:
                        i10 = indexCount;
                        hVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.M));
                        break;
                    case 14:
                        i10 = indexCount;
                        hVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.O));
                        break;
                    case 15:
                        i10 = indexCount;
                        hVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.R));
                        break;
                    case 16:
                        i10 = indexCount;
                        hVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.N));
                        break;
                    case 17:
                        i10 = indexCount;
                        hVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f3142d));
                        break;
                    case 18:
                        i10 = indexCount;
                        hVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f3144e));
                        break;
                    case 19:
                        i10 = indexCount;
                        hVar.a(19, typedArrayObtainStyledAttributes.getFloat(index, jVar.f));
                        break;
                    case 20:
                        i10 = indexCount;
                        hVar.a(20, typedArrayObtainStyledAttributes.getFloat(index, jVar.f3170w));
                        break;
                    case 21:
                        i10 = indexCount;
                        hVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f3140c));
                        break;
                    case 22:
                        i10 = indexCount;
                        hVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, lVar.f3182a)]);
                        break;
                    case 23:
                        i10 = indexCount;
                        hVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f3138b));
                        break;
                    case 24:
                        i10 = indexCount;
                        hVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.F));
                        break;
                    case 27:
                        i10 = indexCount;
                        hVar.b(27, typedArrayObtainStyledAttributes.getInt(index, jVar.E));
                        break;
                    case 28:
                        i10 = indexCount;
                        hVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.G));
                        break;
                    case 31:
                        i10 = indexCount;
                        hVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.K));
                        break;
                    case 34:
                        i10 = indexCount;
                        hVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.H));
                        break;
                    case 37:
                        i10 = indexCount;
                        hVar.a(37, typedArrayObtainStyledAttributes.getFloat(index, jVar.f3171x));
                        break;
                    case 38:
                        i10 = indexCount;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f3130a);
                        iVar.f3130a = resourceId;
                        hVar.b(38, resourceId);
                        break;
                    case 39:
                        i10 = indexCount;
                        hVar.a(39, typedArrayObtainStyledAttributes.getFloat(index, jVar.U));
                        break;
                    case 40:
                        i10 = indexCount;
                        hVar.a(40, typedArrayObtainStyledAttributes.getFloat(index, jVar.T));
                        break;
                    case 41:
                        i10 = indexCount;
                        hVar.b(41, typedArrayObtainStyledAttributes.getInt(index, jVar.V));
                        break;
                    case 42:
                        i10 = indexCount;
                        hVar.b(42, typedArrayObtainStyledAttributes.getInt(index, jVar.W));
                        break;
                    case 43:
                        i10 = indexCount;
                        hVar.a(43, typedArrayObtainStyledAttributes.getFloat(index, lVar.f3184c));
                        break;
                    case 44:
                        i10 = indexCount;
                        hVar.d(44, true);
                        hVar.a(44, typedArrayObtainStyledAttributes.getDimension(index, mVar.f3197m));
                        break;
                    case 45:
                        i10 = indexCount;
                        hVar.a(45, typedArrayObtainStyledAttributes.getFloat(index, mVar.f3188b));
                        break;
                    case 46:
                        i10 = indexCount;
                        hVar.a(46, typedArrayObtainStyledAttributes.getFloat(index, mVar.f3189c));
                        break;
                    case 47:
                        i10 = indexCount;
                        hVar.a(47, typedArrayObtainStyledAttributes.getFloat(index, mVar.f3190d));
                        break;
                    case 48:
                        i10 = indexCount;
                        hVar.a(48, typedArrayObtainStyledAttributes.getFloat(index, mVar.f3191e));
                        break;
                    case 49:
                        i10 = indexCount;
                        hVar.a(49, typedArrayObtainStyledAttributes.getDimension(index, mVar.f));
                        break;
                    case 50:
                        i10 = indexCount;
                        hVar.a(50, typedArrayObtainStyledAttributes.getDimension(index, mVar.f3192g));
                        break;
                    case 51:
                        i10 = indexCount;
                        hVar.a(51, typedArrayObtainStyledAttributes.getDimension(index, mVar.i));
                        break;
                    case 52:
                        i10 = indexCount;
                        hVar.a(52, typedArrayObtainStyledAttributes.getDimension(index, mVar.f3194j));
                        break;
                    case 53:
                        i10 = indexCount;
                        hVar.a(53, typedArrayObtainStyledAttributes.getDimension(index, mVar.f3195k));
                        break;
                    case 54:
                        i10 = indexCount;
                        hVar.b(54, typedArrayObtainStyledAttributes.getInt(index, jVar.X));
                        break;
                    case 55:
                        i10 = indexCount;
                        hVar.b(55, typedArrayObtainStyledAttributes.getInt(index, jVar.Y));
                        break;
                    case 56:
                        i10 = indexCount;
                        hVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.Z));
                        break;
                    case 57:
                        i10 = indexCount;
                        hVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f3137a0));
                        break;
                    case 58:
                        i10 = indexCount;
                        hVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f3139b0));
                        break;
                    case 59:
                        i10 = indexCount;
                        hVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f3141c0));
                        break;
                    case 60:
                        i10 = indexCount;
                        hVar.a(60, typedArrayObtainStyledAttributes.getFloat(index, mVar.f3187a));
                        break;
                    case 62:
                        i10 = indexCount;
                        hVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.A));
                        break;
                    case 63:
                        i10 = indexCount;
                        hVar.a(63, typedArrayObtainStyledAttributes.getFloat(index, jVar.B));
                        break;
                    case 64:
                        i10 = indexCount;
                        hVar.b(64, f(typedArrayObtainStyledAttributes, index, kVar.f3175a));
                        break;
                    case 65:
                        i10 = indexCount;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            hVar.c(65, typedArrayObtainStyledAttributes.getString(index));
                        } else {
                            hVar.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                        }
                        break;
                    case 66:
                        i10 = indexCount;
                        hVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i10 = indexCount;
                        hVar.a(67, typedArrayObtainStyledAttributes.getFloat(index, kVar.f3179e));
                        break;
                    case 68:
                        i10 = indexCount;
                        hVar.a(68, typedArrayObtainStyledAttributes.getFloat(index, lVar.f3185d));
                        break;
                    case 69:
                        i10 = indexCount;
                        hVar.a(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i10 = indexCount;
                        hVar.a(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i10 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i10 = indexCount;
                        hVar.b(72, typedArrayObtainStyledAttributes.getInt(index, jVar.f3146f0));
                        break;
                    case 73:
                        i10 = indexCount;
                        hVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f3148g0));
                        break;
                    case 74:
                        i10 = indexCount;
                        hVar.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i10 = indexCount;
                        hVar.d(75, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f3161n0));
                        break;
                    case 76:
                        i10 = indexCount;
                        hVar.b(76, typedArrayObtainStyledAttributes.getInt(index, kVar.f3177c));
                        break;
                    case 77:
                        i10 = indexCount;
                        hVar.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i10 = indexCount;
                        hVar.b(78, typedArrayObtainStyledAttributes.getInt(index, lVar.f3183b));
                        break;
                    case 79:
                        i10 = indexCount;
                        hVar.a(79, typedArrayObtainStyledAttributes.getFloat(index, kVar.f3178d));
                        break;
                    case 80:
                        i10 = indexCount;
                        hVar.d(80, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f3157l0));
                        break;
                    case 81:
                        i10 = indexCount;
                        hVar.d(81, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f3159m0));
                        break;
                    case 82:
                        i10 = indexCount;
                        hVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, kVar.f3176b));
                        break;
                    case 83:
                        i10 = indexCount;
                        hVar.b(83, f(typedArrayObtainStyledAttributes, index, mVar.f3193h));
                        break;
                    case 84:
                        i10 = indexCount;
                        hVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, kVar.f3180g));
                        break;
                    case 85:
                        i10 = indexCount;
                        hVar.a(85, typedArrayObtainStyledAttributes.getFloat(index, kVar.f));
                        break;
                    case 86:
                        i10 = indexCount;
                        int i13 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i13 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            kVar.i = resourceId2;
                            hVar.b(89, resourceId2);
                            if (kVar.i != -1) {
                                hVar.b(88, -2);
                            }
                        } else if (i13 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            kVar.f3181h = string;
                            hVar.c(90, string);
                            if (kVar.f3181h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                kVar.i = resourceId3;
                                hVar.b(89, resourceId3);
                                hVar.b(88, -2);
                            } else {
                                hVar.b(88, -1);
                            }
                        } else {
                            hVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, kVar.i));
                        }
                        break;
                    case 87:
                        i10 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i10 = indexCount;
                        hVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.L));
                        break;
                    case 94:
                        i10 = indexCount;
                        hVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.S));
                        break;
                    case 95:
                        i10 = indexCount;
                        g(hVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i10 = indexCount;
                        g(hVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i10 = indexCount;
                        hVar.b(97, typedArrayObtainStyledAttributes.getInt(index, jVar.o0));
                        break;
                    case 98:
                        i10 = indexCount;
                        int i14 = c0.a.L;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            iVar.f3130a = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f3130a);
                        }
                        break;
                    case 99:
                        i10 = indexCount;
                        hVar.d(99, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f3147g));
                        break;
                }
                i11 = i12 + 1;
            }
        } else {
            int i15 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i15 < indexCount2; indexCount2 = i) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i15);
                if (index2 != r.Constraint_android_id && r.Constraint_android_layout_marginStart != index2 && r.Constraint_android_layout_marginEnd != index2) {
                    kVar.getClass();
                    jVar.getClass();
                    mVar.getClass();
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        jVar.f3163p = f(typedArrayObtainStyledAttributes, index2, jVar.f3163p);
                        continue;
                        i15++;
                        break;
                    case 2:
                        i = indexCount2;
                        jVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.I);
                        continue;
                        i15++;
                        break;
                    case 3:
                        i = indexCount2;
                        jVar.f3162o = f(typedArrayObtainStyledAttributes, index2, jVar.f3162o);
                        continue;
                        i15++;
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        i = indexCount2;
                        jVar.f3160n = f(typedArrayObtainStyledAttributes, index2, jVar.f3160n);
                        continue;
                        i15++;
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        i = indexCount2;
                        jVar.f3172y = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i15++;
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        i = indexCount2;
                        jVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.C);
                        continue;
                        i15++;
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        i = indexCount2;
                        jVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.D);
                        continue;
                        i15++;
                        break;
                    case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                        i = indexCount2;
                        jVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.J);
                        continue;
                        i15++;
                        break;
                    case 9:
                        i = indexCount2;
                        jVar.f3169v = f(typedArrayObtainStyledAttributes, index2, jVar.f3169v);
                        continue;
                        i15++;
                        break;
                    case 10:
                        i = indexCount2;
                        jVar.f3168u = f(typedArrayObtainStyledAttributes, index2, jVar.f3168u);
                        continue;
                        i15++;
                        break;
                    case 11:
                        i = indexCount2;
                        jVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.P);
                        continue;
                        i15++;
                        break;
                    case 12:
                        i = indexCount2;
                        jVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.Q);
                        continue;
                        i15++;
                        break;
                    case 13:
                        i = indexCount2;
                        jVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.M);
                        continue;
                        i15++;
                        break;
                    case 14:
                        i = indexCount2;
                        jVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.O);
                        continue;
                        i15++;
                        break;
                    case 15:
                        i = indexCount2;
                        jVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.R);
                        continue;
                        i15++;
                        break;
                    case 16:
                        i = indexCount2;
                        jVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.N);
                        continue;
                        i15++;
                        break;
                    case 17:
                        i = indexCount2;
                        jVar.f3142d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f3142d);
                        continue;
                        i15++;
                        break;
                    case 18:
                        i = indexCount2;
                        jVar.f3144e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f3144e);
                        continue;
                        i15++;
                        break;
                    case 19:
                        i = indexCount2;
                        jVar.f = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f);
                        continue;
                        i15++;
                        break;
                    case 20:
                        i = indexCount2;
                        jVar.f3170w = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f3170w);
                        continue;
                        i15++;
                        break;
                    case 21:
                        i = indexCount2;
                        jVar.f3140c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f3140c);
                        continue;
                        i15++;
                        break;
                    case 22:
                        i = indexCount2;
                        int i16 = typedArrayObtainStyledAttributes.getInt(index2, lVar.f3182a);
                        lVar.f3182a = i16;
                        lVar.f3182a = iArr[i16];
                        continue;
                        i15++;
                        break;
                    case 23:
                        i = indexCount2;
                        jVar.f3138b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f3138b);
                        continue;
                        i15++;
                        break;
                    case 24:
                        i = indexCount2;
                        jVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.F);
                        continue;
                        i15++;
                        break;
                    case 25:
                        i = indexCount2;
                        jVar.f3149h = f(typedArrayObtainStyledAttributes, index2, jVar.f3149h);
                        continue;
                        i15++;
                        break;
                    case 26:
                        i = indexCount2;
                        jVar.i = f(typedArrayObtainStyledAttributes, index2, jVar.i);
                        continue;
                        i15++;
                        break;
                    case 27:
                        i = indexCount2;
                        jVar.E = typedArrayObtainStyledAttributes.getInt(index2, jVar.E);
                        continue;
                        i15++;
                        break;
                    case 28:
                        i = indexCount2;
                        jVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.G);
                        continue;
                        i15++;
                        break;
                    case 29:
                        i = indexCount2;
                        jVar.f3152j = f(typedArrayObtainStyledAttributes, index2, jVar.f3152j);
                        continue;
                        i15++;
                        break;
                    case 30:
                        i = indexCount2;
                        jVar.f3154k = f(typedArrayObtainStyledAttributes, index2, jVar.f3154k);
                        continue;
                        i15++;
                        break;
                    case 31:
                        i = indexCount2;
                        jVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.K);
                        continue;
                        i15++;
                        break;
                    case 32:
                        i = indexCount2;
                        jVar.f3166s = f(typedArrayObtainStyledAttributes, index2, jVar.f3166s);
                        continue;
                        i15++;
                        break;
                    case 33:
                        i = indexCount2;
                        jVar.f3167t = f(typedArrayObtainStyledAttributes, index2, jVar.f3167t);
                        continue;
                        i15++;
                        break;
                    case 34:
                        i = indexCount2;
                        jVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.H);
                        continue;
                        i15++;
                        break;
                    case 35:
                        i = indexCount2;
                        jVar.f3158m = f(typedArrayObtainStyledAttributes, index2, jVar.f3158m);
                        continue;
                        i15++;
                        break;
                    case 36:
                        i = indexCount2;
                        jVar.f3156l = f(typedArrayObtainStyledAttributes, index2, jVar.f3156l);
                        continue;
                        i15++;
                        break;
                    case 37:
                        i = indexCount2;
                        jVar.f3171x = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f3171x);
                        continue;
                        i15++;
                        break;
                    case 38:
                        i = indexCount2;
                        iVar.f3130a = typedArrayObtainStyledAttributes.getResourceId(index2, iVar.f3130a);
                        continue;
                        i15++;
                        break;
                    case 39:
                        i = indexCount2;
                        jVar.U = typedArrayObtainStyledAttributes.getFloat(index2, jVar.U);
                        continue;
                        i15++;
                        break;
                    case 40:
                        i = indexCount2;
                        jVar.T = typedArrayObtainStyledAttributes.getFloat(index2, jVar.T);
                        continue;
                        i15++;
                        break;
                    case 41:
                        i = indexCount2;
                        jVar.V = typedArrayObtainStyledAttributes.getInt(index2, jVar.V);
                        continue;
                        i15++;
                        break;
                    case 42:
                        i = indexCount2;
                        jVar.W = typedArrayObtainStyledAttributes.getInt(index2, jVar.W);
                        continue;
                        i15++;
                        break;
                    case 43:
                        i = indexCount2;
                        lVar.f3184c = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f3184c);
                        continue;
                        i15++;
                        break;
                    case 44:
                        i = indexCount2;
                        mVar.f3196l = true;
                        mVar.f3197m = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f3197m);
                        continue;
                        i15++;
                        break;
                    case 45:
                        i = indexCount2;
                        mVar.f3188b = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f3188b);
                        continue;
                        i15++;
                        break;
                    case 46:
                        i = indexCount2;
                        mVar.f3189c = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f3189c);
                        continue;
                        i15++;
                        break;
                    case 47:
                        i = indexCount2;
                        mVar.f3190d = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f3190d);
                        continue;
                        i15++;
                        break;
                    case 48:
                        i = indexCount2;
                        mVar.f3191e = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f3191e);
                        continue;
                        i15++;
                        break;
                    case 49:
                        i = indexCount2;
                        mVar.f = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f);
                        continue;
                        i15++;
                        break;
                    case 50:
                        i = indexCount2;
                        mVar.f3192g = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f3192g);
                        continue;
                        i15++;
                        break;
                    case 51:
                        i = indexCount2;
                        mVar.i = typedArrayObtainStyledAttributes.getDimension(index2, mVar.i);
                        continue;
                        i15++;
                        break;
                    case 52:
                        i = indexCount2;
                        mVar.f3194j = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f3194j);
                        continue;
                        i15++;
                        break;
                    case 53:
                        i = indexCount2;
                        mVar.f3195k = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f3195k);
                        continue;
                        i15++;
                        break;
                    case 54:
                        i = indexCount2;
                        jVar.X = typedArrayObtainStyledAttributes.getInt(index2, jVar.X);
                        continue;
                        i15++;
                        break;
                    case 55:
                        i = indexCount2;
                        jVar.Y = typedArrayObtainStyledAttributes.getInt(index2, jVar.Y);
                        continue;
                        i15++;
                        break;
                    case 56:
                        i = indexCount2;
                        jVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.Z);
                        continue;
                        i15++;
                        break;
                    case 57:
                        i = indexCount2;
                        jVar.f3137a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f3137a0);
                        continue;
                        i15++;
                        break;
                    case 58:
                        i = indexCount2;
                        jVar.f3139b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f3139b0);
                        continue;
                        i15++;
                        break;
                    case 59:
                        i = indexCount2;
                        jVar.f3141c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f3141c0);
                        continue;
                        i15++;
                        break;
                    case 60:
                        i = indexCount2;
                        mVar.f3187a = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f3187a);
                        continue;
                        i15++;
                        break;
                    case 61:
                        i = indexCount2;
                        jVar.f3173z = f(typedArrayObtainStyledAttributes, index2, jVar.f3173z);
                        continue;
                        i15++;
                        break;
                    case 62:
                        i = indexCount2;
                        jVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.A);
                        continue;
                        i15++;
                        break;
                    case 63:
                        i = indexCount2;
                        jVar.B = typedArrayObtainStyledAttributes.getFloat(index2, jVar.B);
                        continue;
                        i15++;
                        break;
                    case 64:
                        i = indexCount2;
                        kVar.f3175a = f(typedArrayObtainStyledAttributes, index2, kVar.f3175a);
                        continue;
                        i15++;
                        break;
                    case 65:
                        i = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            kVar.getClass();
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            kVar.getClass();
                            i15++;
                        }
                        break;
                    case 66:
                        i = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        kVar.getClass();
                        continue;
                        i15++;
                        break;
                    case 67:
                        i = indexCount2;
                        kVar.f3179e = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f3179e);
                        break;
                    case 68:
                        i = indexCount2;
                        lVar.f3185d = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f3185d);
                        break;
                    case 69:
                        i = indexCount2;
                        jVar.f3143d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        jVar.f3145e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        jVar.f3146f0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f3146f0);
                        break;
                    case 73:
                        i = indexCount2;
                        jVar.f3148g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f3148g0);
                        break;
                    case 74:
                        i = indexCount2;
                        jVar.f3153j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        jVar.f3161n0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f3161n0);
                        break;
                    case 76:
                        i = indexCount2;
                        kVar.f3177c = typedArrayObtainStyledAttributes.getInt(index2, kVar.f3177c);
                        break;
                    case 77:
                        i = indexCount2;
                        jVar.f3155k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        lVar.f3183b = typedArrayObtainStyledAttributes.getInt(index2, lVar.f3183b);
                        break;
                    case 79:
                        i = indexCount2;
                        kVar.f3178d = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f3178d);
                        break;
                    case 80:
                        i = indexCount2;
                        jVar.f3157l0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f3157l0);
                        break;
                    case 81:
                        i = indexCount2;
                        jVar.f3159m0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f3159m0);
                        break;
                    case 82:
                        i = indexCount2;
                        kVar.f3176b = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f3176b);
                        break;
                    case 83:
                        i = indexCount2;
                        mVar.f3193h = f(typedArrayObtainStyledAttributes, index2, mVar.f3193h);
                        break;
                    case 84:
                        i = indexCount2;
                        kVar.f3180g = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f3180g);
                        break;
                    case 85:
                        i = indexCount2;
                        kVar.f = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f);
                        break;
                    case 86:
                        i = indexCount2;
                        int i17 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i17 == 1) {
                            kVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i17 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            kVar.f3181h = string2;
                            if (string2.indexOf("/") > 0) {
                                kVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, kVar.i);
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        jVar.f3164q = f(typedArrayObtainStyledAttributes, index2, jVar.f3164q);
                        break;
                    case 92:
                        i = indexCount2;
                        jVar.f3165r = f(typedArrayObtainStyledAttributes, index2, jVar.f3165r);
                        break;
                    case 93:
                        i = indexCount2;
                        jVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.L);
                        break;
                    case 94:
                        i = indexCount2;
                        jVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.S);
                        break;
                    case 95:
                        i = indexCount2;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i15++;
                        break;
                    case 96:
                        i = indexCount2;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        jVar.o0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.o0);
                        break;
                }
                i15++;
            }
            if (jVar.f3153j0 != null) {
                jVar.f3151i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return iVar;
    }

    public static int f(TypedArray typedArray, int i, int i10) {
        int resourceId = typedArray.getResourceId(i, i10);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.n.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(e eVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 > 0.0f && f11 > 0.0f) {
                            if (i == 1) {
                                Math.abs(f11 / f10);
                            } else {
                                Math.abs(f10 / f11);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.G = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ConstraintLayout constraintLayout) {
        boolean z10;
        HashSet hashSet;
        int i;
        HashMap map;
        String resourceEntryName;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = nVar.f3202c;
        HashSet<Integer> hashSet2 = new HashSet(map2.keySet());
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (nVar.f3201b && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (map2.containsKey(Integer.valueOf(id2))) {
                        hashSet2.remove(Integer.valueOf(id2));
                        i iVar = (i) map2.get(Integer.valueOf(id2));
                        if (iVar != null) {
                            l lVar = iVar.f3131b;
                            j jVar = iVar.f3133d;
                            m mVar = iVar.f3134e;
                            if (childAt instanceof a) {
                                jVar.f3150h0 = 1;
                                a aVar = (a) childAt;
                                aVar.setId(id2);
                                aVar.setType(jVar.f3146f0);
                                aVar.setMargin(jVar.f3148g0);
                                aVar.setAllowsGoneWidget(jVar.f3161n0);
                                int[] iArr = jVar.f3151i0;
                                if (iArr != null) {
                                    aVar.setReferencedIds(iArr);
                                } else {
                                    String str = jVar.f3153j0;
                                    if (str != null) {
                                        int[] iArrC = c(aVar, str);
                                        jVar.f3151i0 = iArrC;
                                        aVar.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            iVar.a(eVar);
                            HashMap map3 = iVar.f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map3.keySet()) {
                                b bVar = (b) map3.get(str2);
                                HashSet hashSet3 = hashSet2;
                                String strN = !bVar.f3057a ? q4.a.n("set", str2) : str2;
                                int i11 = i10;
                                try {
                                    int iC = y.e.c(bVar.f3058b);
                                    Class<?> cls2 = Float.TYPE;
                                    Class<?> cls3 = Integer.TYPE;
                                    switch (iC) {
                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                            map = map3;
                                            cls.getMethod(strN, cls3).invoke(childAt, Integer.valueOf(bVar.f3059c));
                                            break;
                                        case 1:
                                            map = map3;
                                            cls.getMethod(strN, cls2).invoke(childAt, Float.valueOf(bVar.f3060d));
                                            break;
                                        case 2:
                                            map = map3;
                                            cls.getMethod(strN, cls3).invoke(childAt, Integer.valueOf(bVar.f3062g));
                                            break;
                                        case 3:
                                            map = map3;
                                            Method method = cls.getMethod(strN, Drawable.class);
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(bVar.f3062g);
                                            method.invoke(childAt, colorDrawable);
                                            break;
                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                            map = map3;
                                            cls.getMethod(strN, CharSequence.class).invoke(childAt, bVar.f3061e);
                                            break;
                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                            map = map3;
                                            cls.getMethod(strN, Boolean.TYPE).invoke(childAt, Boolean.valueOf(bVar.f));
                                            break;
                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                            map = map3;
                                            cls.getMethod(strN, cls2).invoke(childAt, Float.valueOf(bVar.f3060d));
                                            break;
                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                            map = map3;
                                            try {
                                                cls.getMethod(strN, cls3).invoke(childAt, Integer.valueOf(bVar.f3059c));
                                            } catch (IllegalAccessException e9) {
                                                e = e9;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName(), e);
                                            } catch (NoSuchMethodException e10) {
                                                e = e10;
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strN, e);
                                            } catch (InvocationTargetException e11) {
                                                e = e11;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName(), e);
                                            }
                                            break;
                                        default:
                                            map = map3;
                                            break;
                                    }
                                } catch (IllegalAccessException e12) {
                                    e = e12;
                                    map = map3;
                                } catch (NoSuchMethodException e13) {
                                    e = e13;
                                    map = map3;
                                } catch (InvocationTargetException e14) {
                                    e = e14;
                                    map = map3;
                                }
                                hashSet2 = hashSet3;
                                i10 = i11;
                                map3 = map;
                            }
                            hashSet = hashSet2;
                            i = i10;
                            childAt.setLayoutParams(eVar);
                            if (lVar.f3183b == 0) {
                                childAt.setVisibility(lVar.f3182a);
                            }
                            childAt.setAlpha(lVar.f3184c);
                            childAt.setRotation(mVar.f3187a);
                            childAt.setRotationX(mVar.f3188b);
                            childAt.setRotationY(mVar.f3189c);
                            childAt.setScaleX(mVar.f3190d);
                            childAt.setScaleY(mVar.f3191e);
                            if (mVar.f3193h != -1) {
                                if (((View) childAt.getParent()).findViewById(mVar.f3193h) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(mVar.f)) {
                                    childAt.setPivotX(mVar.f);
                                }
                                if (!Float.isNaN(mVar.f3192g)) {
                                    childAt.setPivotY(mVar.f3192g);
                                }
                            }
                            childAt.setTranslationX(mVar.i);
                            childAt.setTranslationY(mVar.f3194j);
                            childAt.setTranslationZ(mVar.f3195k);
                            if (mVar.f3196l) {
                                childAt.setElevation(mVar.f3197m);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i = i10;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
                i10 = i + 1;
                nVar = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i = i10;
            i10 = i + 1;
            nVar = this;
            hashSet2 = hashSet;
        }
        boolean z11 = false;
        for (Integer num : hashSet2) {
            i iVar2 = (i) map2.get(num);
            if (iVar2 != null) {
                j jVar2 = iVar2.f3133d;
                if (jVar2.f3150h0 == 1) {
                    Context context = constraintLayout.getContext();
                    a aVar2 = new a(context);
                    aVar2.f3063v = new int[32];
                    aVar2.B = new HashMap();
                    aVar2.f3065x = context;
                    a0.a aVar3 = new a0.a();
                    z10 = z11 ? 1 : 0;
                    aVar3.f0s0 = z10 ? 1 : 0;
                    aVar3.f1t0 = true;
                    aVar3.f2u0 = z10 ? 1 : 0;
                    aVar3.f3v0 = z10;
                    aVar2.E = aVar3;
                    aVar2.f3066y = aVar3;
                    aVar2.i();
                    aVar2.setVisibility(8);
                    aVar2.setId(num.intValue());
                    int[] iArr2 = jVar2.f3151i0;
                    if (iArr2 != null) {
                        aVar2.setReferencedIds(iArr2);
                    } else {
                        String str3 = jVar2.f3153j0;
                        if (str3 != null) {
                            int[] iArrC2 = c(aVar2, str3);
                            jVar2.f3151i0 = iArrC2;
                            aVar2.setReferencedIds(iArrC2);
                        }
                    }
                    aVar2.setType(jVar2.f3146f0);
                    aVar2.setMargin(jVar2.f3148g0);
                    e eVarG = ConstraintLayout.g();
                    aVar2.i();
                    iVar2.a(eVarG);
                    constraintLayout.addView(aVar2, eVarG);
                } else {
                    z10 = z11 ? 1 : 0;
                }
                if (jVar2.f3136a) {
                    View pVar = new p(constraintLayout.getContext());
                    pVar.setId(num.intValue());
                    e eVarG2 = ConstraintLayout.g();
                    iVar2.a(eVarG2);
                    constraintLayout.addView(pVar, eVarG2);
                }
                z11 = z10;
            }
        }
        for (int i12 = (z11 ? 1 : 0) == true ? 1 : 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof c) {
                ((c) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i;
        HashMap map;
        int i10;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = nVar.f3202c;
        map2.clear();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            e eVar = (e) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (nVar.f3201b && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map2.containsKey(Integer.valueOf(id2))) {
                map2.put(Integer.valueOf(id2), new i());
            }
            i iVar = (i) map2.get(Integer.valueOf(id2));
            if (iVar == null) {
                i = childCount;
                map = map2;
                i10 = i11;
            } else {
                l lVar = iVar.f3131b;
                j jVar = iVar.f3133d;
                m mVar = iVar.f3134e;
                i = childCount;
                HashMap map3 = new HashMap();
                map = map2;
                Class<?> cls = childAt.getClass();
                i10 = i11;
                HashMap map4 = nVar.f3200a;
                for (String str : map4.keySet()) {
                    b bVar = (b) map4.get(str);
                    HashMap map5 = map4;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new b(bVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            map3.put(str, new b(bVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e9) {
                        Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName(), e9);
                    } catch (NoSuchMethodException e10) {
                        Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e10);
                    } catch (InvocationTargetException e11) {
                        Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName(), e11);
                    }
                    map4 = map5;
                }
                iVar.f = map3;
                iVar.f3130a = id2;
                jVar.f3149h = eVar.f3077e;
                jVar.i = eVar.f;
                jVar.f3152j = eVar.f3080g;
                jVar.f3154k = eVar.f3082h;
                jVar.f3156l = eVar.i;
                jVar.f3158m = eVar.f3085j;
                jVar.f3160n = eVar.f3087k;
                jVar.f3162o = eVar.f3089l;
                jVar.f3163p = eVar.f3091m;
                jVar.f3164q = eVar.f3093n;
                jVar.f3165r = eVar.f3095o;
                jVar.f3166s = eVar.f3100s;
                jVar.f3167t = eVar.f3101t;
                jVar.f3168u = eVar.f3102u;
                jVar.f3169v = eVar.f3103v;
                jVar.f3170w = eVar.E;
                jVar.f3171x = eVar.F;
                jVar.f3172y = eVar.G;
                jVar.f3173z = eVar.f3096p;
                jVar.A = eVar.f3098q;
                jVar.B = eVar.f3099r;
                jVar.C = eVar.T;
                jVar.D = eVar.U;
                jVar.E = eVar.V;
                jVar.f = eVar.f3073c;
                jVar.f3142d = eVar.f3069a;
                jVar.f3144e = eVar.f3071b;
                jVar.f3138b = ((ViewGroup.MarginLayoutParams) eVar).width;
                jVar.f3140c = ((ViewGroup.MarginLayoutParams) eVar).height;
                jVar.F = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                jVar.G = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                jVar.H = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                jVar.I = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                jVar.L = eVar.D;
                jVar.T = eVar.I;
                jVar.U = eVar.H;
                jVar.W = eVar.K;
                jVar.V = eVar.J;
                jVar.f3157l0 = eVar.W;
                jVar.f3159m0 = eVar.X;
                jVar.X = eVar.L;
                jVar.Y = eVar.M;
                jVar.Z = eVar.P;
                jVar.f3137a0 = eVar.Q;
                jVar.f3139b0 = eVar.N;
                jVar.f3141c0 = eVar.O;
                jVar.f3143d0 = eVar.R;
                jVar.f3145e0 = eVar.S;
                jVar.f3155k0 = eVar.Y;
                jVar.N = eVar.f3105x;
                jVar.P = eVar.f3107z;
                jVar.M = eVar.f3104w;
                jVar.O = eVar.f3106y;
                jVar.R = eVar.A;
                jVar.Q = eVar.B;
                jVar.S = eVar.C;
                jVar.o0 = eVar.Z;
                jVar.J = eVar.getMarginEnd();
                jVar.K = eVar.getMarginStart();
                lVar.f3182a = childAt.getVisibility();
                lVar.f3184c = childAt.getAlpha();
                mVar.f3187a = childAt.getRotation();
                mVar.f3188b = childAt.getRotationX();
                mVar.f3189c = childAt.getRotationY();
                mVar.f3190d = childAt.getScaleX();
                mVar.f3191e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    mVar.f = pivotX;
                    mVar.f3192g = pivotY;
                }
                mVar.i = childAt.getTranslationX();
                mVar.f3194j = childAt.getTranslationY();
                mVar.f3195k = childAt.getTranslationZ();
                if (mVar.f3196l) {
                    mVar.f3197m = childAt.getElevation();
                }
                if (childAt instanceof a) {
                    a aVar = (a) childAt;
                    jVar.f3161n0 = aVar.getAllowsGoneWidget();
                    jVar.f3151i0 = aVar.getReferencedIds();
                    jVar.f3146f0 = aVar.getType();
                    jVar.f3148g0 = aVar.getMargin();
                }
            }
            i11 = i10 + 1;
            nVar = this;
            childCount = i;
            map2 = map;
        }
    }

    public final void e(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    i iVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        iVarD.f3133d.f3136a = true;
                    }
                    this.f3202c.put(Integer.valueOf(iVarD.f3130a), iVarD);
                }
            }
        } catch (IOException e9) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e9);
        } catch (XmlPullParserException e10) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e10);
        }
    }
}
