package zstu.edu.eduservice.service;

import zstu.edu.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import zstu.edu.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);
}
