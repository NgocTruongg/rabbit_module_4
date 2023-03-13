package com.example.blog.service.Impl;

import com.example.blog.dto.BlogDTO;
import com.example.blog.dto.CategoryDTO;
import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
@Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<BlogDTO> findAll(Pageable pageable) {
        Page<Blog> blogPage = blogRepository.findAll(pageable);
        List<BlogDTO> blogDTOList = new ArrayList<>();
        BlogDTO blogDTO;
        for (Blog blog : blogPage){
            blogDTO = new BlogDTO();
            blogDTO.setCategoryDTO(new CategoryDTO());
            BeanUtils.copyProperties(blog.getCategory(), blogDTO.getCategoryDTO());
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTOList.add(blogDTO);
        }
        return new PageImpl<>(blogDTOList);
    }

    @Override
    public BlogDTO findById(int id) {
        BlogDTO blogDTO = new BlogDTO();
        Blog blog = blogRepository.findById(id).get();
        blogDTO.setCategoryDTO(new CategoryDTO());
        BeanUtils.copyProperties(blog.getCategory(), blogDTO.getCategoryDTO());
        BeanUtils.copyProperties(blog, blogDTO);
        return blogDTO;
    }
}
